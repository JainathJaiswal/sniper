package com.jai.world.repository;

import org.springframework.data.repository.CrudRepository;

import com.jai.world.repository.jpadomain.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
