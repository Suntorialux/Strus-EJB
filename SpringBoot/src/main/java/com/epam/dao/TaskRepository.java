package com.epam.dao;

import org.springframework.data.repository.CrudRepository;

import com.epam.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
