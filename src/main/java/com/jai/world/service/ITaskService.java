package com.jai.world.service;

import java.util.List;

import com.jai.world.repository.jpadomain.Task;

public interface ITaskService {

	public List<Task> getAllTasks();
	public Task addTask(Task task);
	public Task updateTask(Task task);
	public void deleteTask(Long taskId);
	public Task getTaskById(Long id);

}
