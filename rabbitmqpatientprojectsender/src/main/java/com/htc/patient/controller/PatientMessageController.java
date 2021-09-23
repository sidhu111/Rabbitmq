package com.htc.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.patient.transpoter.SimpleMessageSender;

@RestController
@RequestMapping(value="/greet")
public class PatientMessageController {

	@Autowired
	private SimpleMessageSender simpleMessageSender;
	
	@GetMapping
	public String producer()
	
	{
		simpleMessageSender.SendMessage();
		return "Sent message to the queue";
		
	}
}
