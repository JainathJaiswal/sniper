package com.jai.world.rest.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.jai.world.repository.jpadomain.Task;
import com.jai.world.rest.ITaskApi;
import com.jai.world.service.ITaskService;

@Component
public class TaskApi implements ITaskApi {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskApi.class);

	@Autowired
	private ITaskService iTaskService;
	
	@Override
	public ResponseEntity<List<Task>> getAllTasks() {
		LOGGER.debug("All tasks");
		return new ResponseEntity<>(iTaskService.getAllTasks(),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		LOGGER.debug("Task data is: {}",task);
		task.setCreatedDate(new Date());
		task.setCreatedBy("Admin");
		return new ResponseEntity<>(iTaskService.addTask(task),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteTask(@PathVariable Long id) {
		LOGGER.debug("Id is: {}",id);
		iTaskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Task> updateTask(@PathVariable("id") Long id,@RequestBody Task task) {
		LOGGER.debug("Id is: {} and task data is: {}",id,task);
		Task retTask = iTaskService.getTaskById(id);
	        if(retTask == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } else {
	        	task.setUpdatedDate(new Date());
	        	task.setCompleted(task.getCompleted());
	        	task.setUpdatedBy("User");
	        	Task updatedTask = iTaskService.addTask(task);
	            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	        }
	}
	
	@Override
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
		LOGGER.debug("Id is: {}",id);
		Task task = iTaskService.getTaskById(id);
        if(task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }
    }
}
