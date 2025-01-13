import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ConditionTester {
    boolean condition1;
    boolean condition2;
    boolean condition3;
    boolean dosomething1Called;
    boolean dosomething2Called;
    boolean dosomething3Called;

    @Test
    public void testCondition1True() {
        condition1 = true;
        condition2 = false;
        condition3 = false;
        dosomething1Called = false;
        doSomething();
        assertTrue(dosomething1Called);
    }

    @Test
    public void testCondition1False() {
        condition1 = false;
        condition2 = false;
        condition3 = false;
        dosomething1Called = false;
        doSomething();
        assertFalse(dosomething1Called);
    }

    @Test
    public void testCondition2True() {
        condition1 = false;
        condition2 = true;
        condition3 = false;
        dosomething2Called = false;
        doSomething();
        assertTrue(dosomething2Called);
    }

    @Test
    public void testCondition2False() {
        condition1 = false;
        condition2 = false;
        condition3 = false;
        dosomething2Called = false;
        doSomething();
        assertFalse(dosomething2Called);
    }

    @Test
    public void testCondition3True() {
        condition1 = false;
        condition2 = false;
        condition3 = true;
        dosomething3Called = false;
        doSomething();
        assertTrue(dosomething3Called);
    }

    @Test
    public void testCondition3False() {
        condition1 = false;
        condition2 = false;
        condition3 = false;
        dosomething3Called = false;
        doSomething();
        assertFalse(dosomething3Called);
    }

    public void doSomething() {
        if (condition1) {
            dosomething1();
        }
        if (condition2) {
            dosomething2();
        }
        if (condition3) {
            dosomething3();
        }
    }

    public void dosomething1() {
        dosomething1Called = true;
    }

    public void dosomething2() {
        dosomething2Called = true;
    }

    public void dosomething3() {
        dosomething3Called = true;
    }

    public static void main(String[] args) {
        org.junit.runner.JUnitCore.main("ConditionTester");
    }
}