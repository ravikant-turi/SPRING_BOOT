package com.example.todowebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
@Service
public class TodoService {
    private  static    List<Todo> todos=new ArrayList<>();
    
    private static int todosCount=5;
    
    static {
    	todos.add(new Todo(1,"ravi","springBoot", 
    			LocalDate.now().plusYears(1), false));
    	todos.add(new Todo(2,"ravi","Ai", 
    			LocalDate.now().plusYears(1), false));
    	todos.add(new Todo(3,"ravi","web dev", 
    			LocalDate.now().plusYears(1), false));
    	todos.add(new Todo(4,"ravi","ml", 
    			LocalDate.now().plusYears(1), false));
    	todos.add(new Todo(5,"ravi","devops", 
    			LocalDate.now().plusYears(1), false));
    
    }
    public List<Todo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		//todo.getId() == id
		// todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
