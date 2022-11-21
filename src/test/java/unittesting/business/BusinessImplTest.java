package unittesting.business;

import org.junit.Test;

import static org.junit.Assert.*;

public class BusinessImplTest {

    @Test
    public void calculateSum_basic() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}