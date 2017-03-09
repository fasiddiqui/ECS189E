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
 * Created by Farjad on 3/8/17.
 */
public class Test_Student {
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
        this.admin.createClass("Test", 2017, "instructor", 1);
        this.student.registerForClass("farjad", "test", 2017);
        this.student.registerForClass("sami", "test", 2017);
        assertFalse(this.student.isRegisteredFor("sami", "test", 2017));
    }

    public void testMakeClass2() {
        this.admin.createClass("Test", 2016, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2016);
        this.student.dropClass("farjad", "test", 2016);
        assertTrue(this.student.isRegisteredFor("farjad", "test", 2017));
    }

    public void testMakeClass3() {
        this.admin.createClass("Test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.student.dropClass("farjad", "test", 2017);
        assertFalse(this.student.isRegisteredFor("farjad", "test", 2017));
    }

    @Test
    public void testMakeClass4() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("instructor", "test", 2017, "hw1", "testhw");
        this.student.submitHomework("farjad", "hw1" , "hi", "test", 2017);
        assertTrue(this.student.hasSubmitted("farjad", "hw1", "test", 2017));
    }

    @Test
    public void testMakeClass5() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("instructor", "test", 2016, "hw1", "testhw");
        this.student.submitHomework("farjad", "hw1" , "hi", "test", 2017);
        assertFalse(this.student.hasSubmitted("farjad", "hw1", "test", 2017));
    }

    @Test
    public void testMakeClass6() {
        this.admin.createClass("test", 2017, "instructor", 15);
        this.student.registerForClass("farjad", "test", 2017);
        this.instructor.addHomework("instructor", "test", 2017, "hw1", "testhw");
        this.student.submitHomework("farjad", "hw1" , "hi", "test", 2017);
        this.student.dropClass("farjad", "test", 2017);
        assertFalse(this.student.hasSubmitted("farjad", "hw1", "test", 2017));
    }
}
