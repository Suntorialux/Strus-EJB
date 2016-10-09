package com.epam.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.model.Task;
import com.epam.service.TaskService;

@RestController
public class SampleRestController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@GetMapping("/allTask")
	public String allTask() {
		return taskService.findAll().toString();
	}

	@GetMapping("/saveTask")
	public String saveTask(@RequestParam String name, @RequestParam String desc) {
		Task task = new Task(name, desc, new Date(), false);
		taskService.save(task);
		return "Task saved!";
	}

	@GetMapping("/deleteTask")
	public String saveTask(@RequestParam int id) {
		taskService.delete(id);
		;
		return "Task deleted!";
	}
}
