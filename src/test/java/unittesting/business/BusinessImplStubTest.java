package unittesting.business;

import org.junit.Test;
import unittesting.data.DataService;

import static org.junit.Assert.assertEquals;

class dataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}

class dataServiceStubEmpty implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {};
    }
}

class dataServiceStubOneValue implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}

public class BusinessImplStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        BusinessImpl business = new BusinessImpl();
        business.setDataService(new dataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        BusinessImpl business = new BusinessImpl();
        business.setDataService(new dataServiceStubEmpty());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        BusinessImpl business = new BusinessImpl();
        business.setDataService(new dataServiceStubOneValue());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}