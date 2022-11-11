package junit_tests;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArraysCompareTest {
    //Arrays.sort
    @Test
    public void testArraySort_RandomArray() {
        int [] numbers = {12, 3, 4, 1};
        int [] expected = {1, 3, 4, 12};
        Arrays.sort(numbers);
        assertArrayEquals(expected, numbers);
    }

    @Test(expected=NullPointerException.class)
    public void testArraySort_NullArray() {
        int [] numbers = null;
        Arrays.sort(numbers);
    }
}
