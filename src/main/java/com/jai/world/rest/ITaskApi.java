package com.jai.world.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.world.repository.jpadomain.Task;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public interface ITaskApi {
	
	@GetMapping(value = "/tasks")
	public ResponseEntity<List<Task>> getAllTasks();

	@PostMapping(value = "/tasks")
	public ResponseEntity<Task> addTask(@RequestBody Task task);
	
	@DeleteMapping(value = "/tasks/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Long id);
	
	@PutMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") Long id,@RequestBody Task task);
	
	@GetMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id);
}
