package mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test() {
        List arrayListSpy = spy(ArrayList.class);
//        assertEquals(0, arrayListSpy.size());
////        stub(arrayListSpy.size()).toReturn(5);
////        assertEquals(5, arrayListSpy.size());
        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy, never()).clear();
    }
}
