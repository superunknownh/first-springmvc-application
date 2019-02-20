package com.example.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.security.LoginService;

/**
 * Todo controller has all the routes to process the CRUD requests related to {@link Todo} model.
 * 
 * We use the @Controller to specify that this class is a controller.
 * We use @SessionAttributes to persist the "username" session variable.
 * 
 * @author hsanchez
 *
 */
@Controller
public class TodoController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	/**
	 * Lists all the {@link Todo}.
	 * 
	 * @uri /list-todos as described in the RequestMapping 'value' value.
	 * @method GET as described in the RequestMapping 'method' value
	 * 
	 * @param model The map model get the session variables and send data the the view.
	 * @return /src/main/webapp/WEB-INF/views/list-todos.jsp
	 */
	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listTodos(ModelMap model) {
		model.put("username", LoginService.getLoggedInUserName(model));
		model.addAttribute("todos", service.retrieveTodos(LoginService.getLoggedInUserName(model)));
		return "todo/list-todos";
	}
	
	/**
	 * Shows the add Todo form.
	 * 
	 * @uri /add-todo
	 * @method GET
	 * 
	 * @return /src/main/webapp/WEB-INF/views/todo.jsp
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodo(ModelMap model) {
		//throw new RuntimeException("Dummy Exception");
		model.put("username", LoginService.getLoggedInUserName(model));
		model.addAttribute("todo", new Todo());
		return "todo/todo";
	}
	
	/**
	 * Adds a {@link Todo} to the list.
	 *
	 * @uri /add-todo
	 * @method POST
	 *
	 * @param model The model map to clear the get parameters.
	 * @param description The {@link Todo} description set as a parameter.
	 * @return A redirecton to {@link listTodos} (<code>/list-todos</code>)
	 */
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (!result.hasErrors()) {
			service.addTodo(LoginService.getLoggedInUserName(model), todo.getDescription(), new Date(), false);
			model.clear();
			return "redirect:list-todos";
		} else {
			return "todo/todo";
		}
	}
	
	/**
	 * Deletes a {@link Todo}.
	 * 
	 * @param model The model map to clear the get parameters.
	 * @param id The Todo's ID to delete.
	 * @return Redirects to /list-todos.
	 */
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam int id) {
		model.clear();
		service.deleteTodo(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String editTodo(ModelMap model, @RequestParam int id) {
		model.clear();
		Todo todo = service.retrieveTodo(id);
		model.put("username", LoginService.getLoggedInUserName(model));
		model.addAttribute("todo", todo);
		return "todo/todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		model.clear();
		if (!result.hasErrors()) {
			service.updateTodo(todo);
			return "redirect:list-todos";
		} else {
			return "todo/todo";
		}
	}

	@Autowired
	TodoService service;
}
