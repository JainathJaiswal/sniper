package com.jai.world.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jai.world.repository.TaskRepository;
import com.jai.world.repository.jpadomain.Task;
import com.jai.world.rest.impl.TaskApi;
import com.jai.world.service.ITaskService;
@Service
public class TaskServiceImpl implements ITaskService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskServiceImpl.class);
	
	@Autowired
	TaskRepository taskRepository;

	@Override
	public List<Task> getAllTasks() {
		LOGGER.debug("All tasks");
		return (List<Task>) taskRepository.findAll();
	}
	
	@Override
	public Task addTask(Task task) {
		LOGGER.debug("Task data is: {}",task);
		return taskRepository.save(task);
	}

	@Override
	public Task updateTask(Task task) {
		LOGGER.debug("Task data is: {}",task);
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		LOGGER.debug("Id is: {}",id);
		taskRepository.delete(id);
		
	}

	@Override
	public Task getTaskById(Long id) {
		LOGGER.debug("Id is: {}",id);
		return taskRepository.findOne(id);
	}
}
