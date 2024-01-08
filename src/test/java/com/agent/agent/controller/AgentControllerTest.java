package com.agent.agent.controller;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.agent.agent.DTO.AgentDTO;
import com.agent.agent.DTO.AuthenticationDTO;
import com.agent.agent.DTO.AuthenticationTokenDTO;
import com.agent.agent.controller.converter.AgentConverter;
import com.agent.agent.modele.Agent;
import com.agent.agent.service.impl.AgentServiceImpl;
import com.agent.agent.service.impl.AuthenticationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class AgentControllerTest extends TestCase {
    @Mock
    private AgentServiceImpl agentService;

    @Mock
    private AuthenticationServiceImpl authenticationService;

    @Mock
    private AgentConverter agentConverter;

    @InjectMocks
    private AgentController agentController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);


    }
    @Test
    public void testCreateAgent() {
        // Arrange
        Agent agent = new Agent(); // Create a sample agent object
        when(agentService.createAgent(any(Agent.class))).thenReturn(agent);

        // Act
        ResponseEntity<Integer> responseEntity = agentController.createAgent(agent);

        // Assert
        assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());

    }
    @Test
    public void testLogin() {
        // Arrange
        AuthenticationDTO authenticationDTO = new AuthenticationDTO(); // Create a sample authenticationDTO object
        AuthenticationTokenDTO expectedToken = new AuthenticationTokenDTO(); // Create a sample expected token
        when(authenticationService.authenticate(eq(authenticationDTO))).thenReturn(expectedToken);

        // Act
        AuthenticationTokenDTO actualToken = agentController.login(authenticationDTO);

        // Assert
        assertEquals(expectedToken, actualToken);
    }
    @Test
    public void testGetCurrentUser() {
        // Arrange
        int agentId = 1;
        Agent expectedAgent = new Agent(); // Create a sample expected agent
        when(agentService.getAgentbyId(eq(agentId))).thenReturn(expectedAgent);

        // Act
        ResponseEntity<?> responseEntity = agentController.getCurrentUser(agentId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedAgent, responseEntity.getBody());
    }
}