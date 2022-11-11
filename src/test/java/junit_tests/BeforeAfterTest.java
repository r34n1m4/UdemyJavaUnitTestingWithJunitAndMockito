package junit_tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeforeAfterTest {

    @Before
    public void setup() {
        System.out.println("Before Test");
    }

    @Test
    public void test1() {
        System.out.println("test1 executed");
    }

    @Test
    public void test2() {
        System.out.println("test2 executed");
    }

    @After
    public void teardown() {
        System.out.println("After Test");
    }
}
