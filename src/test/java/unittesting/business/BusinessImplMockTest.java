package unittesting.business;

import org.junit.Test;
import unittesting.data.DataService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BusinessImplMockTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        BusinessImpl business = new BusinessImpl();
        DataService dataServiceMock = mock(DataService.class);
        //dataServiceMock retrieveAllData new int[] {1,2,3}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        business.setDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        BusinessImpl business = new BusinessImpl();
        DataService dataServiceMock = mock(DataService.class);
        //dataServiceMock retrieveAllData new int[] {}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        business.setDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        BusinessImpl business = new BusinessImpl();
        DataService dataServiceMock = mock(DataService.class);
        //dataServiceMock retrieveAllData new int[] {5}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
        business.setDataService(dataServiceMock);
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}