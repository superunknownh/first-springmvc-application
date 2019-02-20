package com.example.rest.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.Todo;
import com.example.todo.TodoService;

@RestController
public class TodoRestController {
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public List<Todo> listAllTodos() {
		return service.retrieveAllTodos();
	}
	
	@RequestMapping(value = "/todos/{id}", method = RequestMethod.GET)
	public Todo getTodo(@PathVariable int id) {
		return service.retrieveTodo(id);
	}
	
	@Autowired
	TodoService service;

}
