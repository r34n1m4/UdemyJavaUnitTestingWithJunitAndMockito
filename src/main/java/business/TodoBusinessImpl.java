package business;

import api.TodoService;

import java.util.ArrayList;
import java.util.List;
//TodoBusinessImpl SUT - System Under Test
//TodoService - dependency
public class TodoBusinessImpl {
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo : todos) {
            if(todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosRelatedToSpring(String user) {
        List<String> todos = todoService.retrieveTodos(user);
        for (String todo : todos) {
            if(!todo.contains("Spring")) {
                todoService.deleteTodo(todo);
            }
        }
    }
}
