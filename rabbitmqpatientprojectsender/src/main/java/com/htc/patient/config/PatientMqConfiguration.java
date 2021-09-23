package com.htc.patient.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PatientMqConfiguration {

	@Value("${rabbitmq_sender.queue}")
	private String queueName;
	
	@Value("${rabbitmq_sender.exchange}")
	private String exchangeName;
	
	@Value("${rabbitmq_sender.routingkey}")
	private String routingKey;
	
	@Bean
	Queue createQueue()
	{
		
		return new Queue(queueName);
	}
	
	@Bean
	DirectExchange createExchange()
	{
		return new DirectExchange(exchangeName);
	}
	
	//If exchange and queue not binded we need create following bean
	/*
	 * @Bean Binding createBinding(Queue queueName,DirectExchange exchangeName) {
	 * return BindingBuilder.bind(queueName).to(exchangeName).with(routingKey); }
	 */
}

