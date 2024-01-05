package com.agent.agent;

import com.agent.agent.modele.Agent;
import com.agent.agent.modele.Solde;
import com.agent.agent.repository.AgentRepository;
import com.agent.agent.service.AgentService;
import com.agent.agent.service.impl.AgentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;

@SpringBootApplication
public class AgentApplication {

	//private static final String ENDPOINT_URL = "http://localhost:9191/api_transfer/MultiTransfer/client/otp"; // Replace with your endpoint URL

	public static void main(String[] args) {
		//SpringApplication.run(AgentApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(AgentApplication.class, args);

		// Get the AgentService bean from the application context
		AgentServiceImpl agentService = context.getBean(AgentServiceImpl.class);

//		// Create a new Agent object
//		Agent newAgent = new Agent();
//		// Set the agent's properties
//		newAgent.setTitle("Mr");
//		newAgent.setFirstName("John");
//		newAgent.setLastName("Doe");
//		newAgent.setEmail("johndoe@example.com");
//		newAgent.setPassword("password123");
//		newAgent.setBirthday("1980-01-01");
//		newAgent.setIdCard("ID12345678");
//		newAgent.setValidity_of_IDCard(true);
//		newAgent.setPhoneNumber("1234567890");
//		newAgent.setAddress("123 Main St");
//		newAgent.setCity("Sample City");
//		newAgent.setZipCode("12345");
//		newAgent.setCountry("Sample Country");
//
//		Solde initialSoldeM = new Solde();
//		initialSoldeM.setTotal_amount(100000.00); // Example amount
//		initialSoldeM.setUpdatedAt(LocalDateTime.now());
//		newAgent.setSolde(Collections.singletonList(initialSoldeM));


//		// Create a new Solde object for John Doe
//		Solde soldeJohn = new Solde(null, null, LocalDateTime.now(), 100000.00);
//
//		// Create a new Agent object for John Doe
//		Agent newAgent = new Agent(null, null, "Mr", "John", "Doe", "johndoe@example.com", "password123", "1980-01-01", "ID12345678", true, "1234567890", "123 Main St", "Sample City", "12345", "Sample Country", Collections.singletonList(soldeJohn));
//
//		// Save the agent
//		agentService.createAgent(newAgent);

		// Create a new Solde object for Jane Doe
		Solde soldeJane = new Solde(null, null, LocalDateTime.now(), 100000.00);

		// Create a new Agent object for Jane Doe
		Agent femaleAgent = new Agent(null, null, "Ms", "Jane", "Doe", "janedoe@example.com", "securepassword123", "1990-01-01", "ID87654321", true, "0987654321", "456 Elm Street", "Another City", "54321", "Sample Country", Collections.singletonList(soldeJane));

		// Save the second agent
		agentService.createAgent(femaleAgent);


	}


}
