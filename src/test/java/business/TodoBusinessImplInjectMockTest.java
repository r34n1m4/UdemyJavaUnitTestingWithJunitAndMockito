package business;

import api.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;

public class TodoBusinessImplInjectMockTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingMock() {

        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");

        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy something");
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD () {

        //Given
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        //When
        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy something");
        //Then
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD () {

        //Given
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
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
        //Define Argument captor on specific method call
        //Capture the argument

        //Given
        List<String> todos =
                Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        //When
        todoBusinessImpl.deleteTodosRelatedToSpring("Dummy");
        //Then
        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(), is("Learn to sleep at work"));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultiply() {
        //Declare Argument Capture
        //Define Argument captor on specific method call
        //Capture the argument

        //Given
        List<String> todos =
                Arrays.asList("Learn to learn", "Learn Spring", "Learn to sleep at work");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        //When
        todoBusinessImpl.deleteTodosRelatedToSpring("Dummy");
        //Then
        then(todoServiceMock).should(times(2))
                .deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
    }
}
