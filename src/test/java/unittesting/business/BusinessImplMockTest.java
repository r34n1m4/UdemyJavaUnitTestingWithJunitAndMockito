package unittesting.business;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import unittesting.data.DataService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BusinessImplMockTest {

    @InjectMocks
    BusinessImpl business = new BusinessImpl();

    @Mock
    DataService dataServiceMock;

    @Before
    public void before() {
        business.setDataService(dataServiceMock);
    }

    @Test
    public void calculateSumUsingDataService_basic() {
        //dataServiceMock retrieveAllData new int[] {1,2,3}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        //dataServiceMock retrieveAllData new int[] {}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        //dataServiceMock retrieveAllData new int[] {5}
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {5});
        assertEquals(5, business.calculateSumUsingDataService());
    }
}