package com.bb.reminder.reminderdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bb.reminder.reminderdemo.service.ScheduleService;
import com.bb.reminder.reminderdemo.service.TaskRunner;

@RestController
@RequestMapping(value = "/")
public class SchedulerController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value = "/add/{taskKey}/{min}", method = RequestMethod.POST)
	public void addTask(@PathVariable String taskKey,@PathVariable int min) {
		System.out.println("SchedulerControllerAdd|taskKey="+taskKey+"|min="+min);
		scheduleService.addTask(taskKey ,min, new TaskRunner("taskKey:"+taskKey));
	}
	
	@RequestMapping(value = "/remove/{taskKey}", method = RequestMethod.DELETE)
	public void removeTask(@PathVariable String taskKey) {
		System.out.println("SchedulerControllerRemove|taskKey="+taskKey);
		scheduleService.removeTask(taskKey);
	}	

}
