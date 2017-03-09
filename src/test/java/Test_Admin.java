import api.IAdmin;
import api.core.impl.Admin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Vincent on 23/2/2017.
 */
public class Test_Admin {

    private IAdmin admin;

    @Before
    public void setup() {
        this.admin = new Admin();
    }

   @Test
    public void testMakeClass2() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        this.admin.changeCapacity("Test",2017,12);
        assertFalse(this.admin.getClassCapacity("Test", 2017) == 12);
    }

    @Test
    public void testMakeClass() {
        this.admin.createClass("Test", 2016, "Instructor", 0);
        assertFalse(this.admin.classExists("Test", 2016));
    }

    @Test
    public void testMakeClass3() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        this.admin.changeCapacity("Test",2017,20);
        assertTrue(this.admin.getClassCapacity("Test", 2017) == 20);
    }

    @Test
    public void testMakeClass4() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        assertTrue("Instructor" == this.admin.getClassInstructor("Test", 2017));
    }

    @Test
    public void testMakeClass5() {
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertTrue(this.admin.classExists("Test", 2017));
    }

    @Test
    public void testMakeClass6() {
        this.admin.createClass("Test", 2016, "Instructor", 15);
        assertFalse(this.admin.classExists("Test", 2016));
    }

    public void testMakeClass7() {
        this.admin.createClass("Test1", 2017, "Instructor", 15);
        this.admin.createClass("Test", 2017, "Instructor", 15);
        assertFalse(this.admin.classExists("Test", 2016));
    }

}
