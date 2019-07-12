package com.bb.reminder.reminderdemo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private TaskScheduler scheduler;
    private Map<String, ScheduledFuture<?>> configuredTasks = new HashMap<>();
    
    public ScheduleService(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }
    
    public void addTask(String taskKey, int min, Runnable task) {
        ScheduledFuture<?> scheduledFutureTask = scheduler.schedule(task, new CronTrigger("*/"+min+" * * * * *", TimeZone.getTimeZone(TimeZone.getDefault().getID())));
        configuredTasks.put(taskKey, scheduledFutureTask);
    }
    
    public void removeTask(String taskKey) {
        ScheduledFuture<?> scheduledFutureTask = configuredTasks.get(taskKey);
        if(scheduledFutureTask != null) {
        	scheduledFutureTask.cancel(true);
        	configuredTasks.remove(taskKey);
        }
    }
    
}
