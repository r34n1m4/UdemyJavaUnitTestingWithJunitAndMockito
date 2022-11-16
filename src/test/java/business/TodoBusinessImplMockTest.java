package business;

import api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;


public class TodoBusinessImplMockTest {
    @Test
    public void testRetrieveTodosRelatedToSpring_usingMock() {

        TodoService todoServiceMock = mock(TodoService.class);

        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy something");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD () {

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy something");
        //Then
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD () {

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        //When
        todoBusinessImpl.deleteTodosRelatedToSpring("Dummy");
        //Then
        then(todoServiceMock).should().deleteTodo("Learn to sleep at work");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
        then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {
        //Declare Argument Capture
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //Define Argument captor on specific method call
        //Capture the argument

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        //When
        todoBusinessImpl.deleteTodosRelatedToSpring("Dummy");
        //Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to sleep at work"));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultiply() {
        //Declare Argument Capture
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        //Define Argument captor on specific method call
        //Capture the argument

        //Given
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos =
                Arrays.asList("Learn to learn", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        //When
        todoBusinessImpl.deleteTodosRelatedToSpring("Dummy");
        //Then
        then(todoServiceMock).should(times(2))
                .deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
