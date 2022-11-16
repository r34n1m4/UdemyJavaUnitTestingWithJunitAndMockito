package business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    public void mockSize() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void mockGet() {
        List listMock = mock(List.class);
        //Argument matcher
        when(listMock.get(anyInt())).thenReturn("String");
        assertEquals("String", listMock.get(0));
        assertEquals("String", listMock.get(9));
    }

    @Test(expected = RuntimeException.class)
    public void mockException() {
        List listMock = mock(List.class);
        //Argument matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("some exception"));
        listMock.get(0);
    }

    @Test
    public void mockBDD() {
        //Given
        List<String> listMock = mock(List.class);
        //Argument matcher
        given(listMock.get(anyInt())).willReturn("String");
        //When
        String firstElement = listMock.get(0);
        //Then
        assertThat(firstElement, is("String"));
    }
}
