package com.bb.reminder.reminderdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ReminderDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReminderDemoApplication.class, args);
	}

}
