package business;

import api.TodoService;
import api.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


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
}
