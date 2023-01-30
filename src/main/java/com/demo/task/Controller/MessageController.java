package com.demo.task.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.task.Entity.Payment;
import com.demo.task.configuration.ApplicationConfig;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private ApplicationConfig applicationConfig;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	/*
	 * used for initiate payment request
	 */
	@PostMapping("/initiate_payment")
	public ResponseEntity<Payment> initiatePaymentRequest(@RequestBody Payment payment) {
		LOGGER.info("Received payment request");
		
		//publishing payment request to queue
		rabbitTemplate.convertAndSend(applicationConfig.getExchangeName(), applicationConfig.getRoutingKeyName(), payment);
		return ResponseEntity.ok(payment);
	}

}
