package com.bb.reminder.reminderdemo.service;

public class TaskRunner implements Runnable{
	
	private String value;
	
	public TaskRunner(String value) {
		this.value = value;
	}

	@Override
	public void run() {
		System.out.println(value);
	}

}
