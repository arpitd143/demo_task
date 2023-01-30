package com.demo.task.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.task.configuration.ApplicationConfig;

@WebMvcTest
class MessageControllerTest {
	
	@MockBean
	private ApplicationConfig applicationConfig;
	
	@MockBean
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void initiatePaymentRequestSuccessfullyTest() {
		
		

		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/initiate_payment")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{\r\n" + "    \"transactionId\":12,\r\n" + "	\"amount\": 32.50,\r\n"
							+ "	\"status\": \"rejected\",\r\n" + "	\"username\":\"test\",\r\n"
							+ "	\"password\":\"test\",\r\n" + "	\"description\": \"payment rejected\",\r\n"
							+ "	\"customerId\": 1256845,\r\n" + "	\"currency\": \"INR\",\r\n"
							+ "	\"mobileNumber\":\"+918569584525\",\r\n" + "	\"country\":\"IN\"\r\n" + "    }"))
					.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
