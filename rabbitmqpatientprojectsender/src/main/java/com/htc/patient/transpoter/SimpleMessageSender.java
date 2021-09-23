package com.htc.patient.transpoter;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SimpleMessageSender {
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	Exchange exchange;
	
	@Value("${rabbitmq_sender.routingkey}")
	private String routingKey;
	
	
	public void SendMessage()
	{
		this.rabbitTemplate.convertAndSend(exchange.getName(),routingKey,new String("Sending from doctors rebbitmq"));
	}

}
