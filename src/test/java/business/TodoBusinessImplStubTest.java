package business;

import api.TodoService;
import api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class TodoBusinessImplStubTest {
    @Test
    public void testRetrieveTodosRelatedToSpring_usingStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> filteredTodos =
                todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy something");
        assertEquals(2, filteredTodos.size());
    }
}
