package powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class MockingStaticMethodTest {
    //Specific Runner
    //Initialize UtilityClass.class (in this case)
    //Mock

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingMock() {

        List<Integer> stats = Arrays.asList(1,2,3);

        when(dependency.retrieveAllStats()).thenReturn(stats);
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(6)).thenReturn(150);
        int result = systemUnderTest.methodCallingAStaticMethod();
        assertEquals(150, result);

        PowerMockito.verifyStatic();
        UtilityClass.staticMethod(6);
    }
}
