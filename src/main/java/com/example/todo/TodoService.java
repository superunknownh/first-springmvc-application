package com.example.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * This service manages the {@link Todo} operations.
 * 
 * @author hsanchez
 *
 *         We use @Service to mark this class a service that can be 'Autowired'.
 *
 */
@Service
public class TodoService {

	public List<Todo> retrieveAllTodos() {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : database) {
			filteredTodos.add(todo);
		}
		return filteredTodos;
	}
	
	/**
	 * Get the Todos of a user.
	 * 
	 * @param user The user to get the Todos.
	 * @return The user's Todos.
	 */
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : database) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}

	/**
	 * Add a new {@link Todo}.
	 * 
	 * @param user        The Todo owner.
	 * @param description The Todo description.
	 * @param targetDate  The Todo target date.
	 * @param isDone      If the Todo is done.
	 */
	public void addTodo(String user, String description, Date targetDate, boolean isDone) {
		database.add(new Todo(database.size() + 1, user, description, targetDate, isDone));
	}

	/**
	 * Remove a {@link Todo} from the database with the given ID.
	 * 
	 * @param id The Todo ID to remove.
	 */
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = database.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Todo retrieveTodo(int id) {
		for (Todo todo : database) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo editTodo) {
		for (Todo todo : database) {
			if (todo.getId() == editTodo.getId()) {
				todo.setId(editTodo.getId());
				todo.setDescription(editTodo.getDescription());
				todo.setTargetDate(editTodo.getTargetDate());
				todo.setDone(editTodo.isDone());
				break;
			}
		}
	}

	/**
	 * The fake database of Todos.
	 */
	private static List<Todo> database = new ArrayList<Todo>();
	static {
		database.add(new Todo(2, "hsanchez", "Learn Java Spring MVC", new Date(), false));
		database.add(new Todo(4, "hsanchez", "Learn unit testing with C#", new Date(), true));
	}
}
