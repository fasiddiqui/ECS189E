import api.IAdmin;
import api.IInstructor;
import api.IStudent;
import api.core.impl.Admin;
import api.core.impl.Instructor;
import api.core.impl.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 23/2/2017.
 */
public class Test_Instructor {

    private IInstructor instructor;
    private IAdmin admin;
    private IStudent student;

    @Before
    public void setup() {
        this.instructor = new Instructor();
        this.admin = new Admin();
        this.student = new Student();
    }


    @Test
    public void testMakeClass() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("instructor", "test", 2017, "hw1", "testhw");;
        assertFalse(this.instructor.homeworkExists("test", 2017, "hw1"));
    }

    @Test
    public void testMakeClass2() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("instructor", "test", 2017, "hw1", "testhw");
        this.instructor.assignGrade("instructor", "test", 2017, "hw1", "Farjad", 99);
        assertFalse(this.instructor.getGrade("test", 2017, "hw1", "Farjad") == 99);
    }

    @Test
    public void testMakeClass3() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("Instructor2", "test", 2017, "hw1", "testhw");
        this.instructor.assignGrade("instructor", "test", 2017, "hw1", "Farjad", 99);
        assertFalse(this.instructor.homeworkExists("test", 2017, "hw1"));
    }

    @Test
    public void testMakeClass4() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("Instructor2", "test", 2017, "hw1", "testhw");
        this.student.submitHomework("farjad", "hw2" , "hi", "test", 2017);
        this.instructor.assignGrade("instructor", "test", 2017, "hw2", "Farjad", 99);
        assertFalse(this.instructor.getGrade("test", 2017, "hw1", "Farjad") == 99);
    }

    @Test
    public void testMakeClass5() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("Instructor", "test", 2017, "hw1", "hw");
        this.student.submitHomework("farjad", "hw2" , "hi", "test", 2017);
        this.instructor.assignGrade("instructor", "test", 2017, "hw1", "Farjad", 99);
        assertTrue(this.instructor.getGrade("test", 2017, "hw1", "Farjad") == 99);
    }

}
