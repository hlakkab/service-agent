package com.agent.agent.controller;

import junit.framework.TestCase;
import org.junit.Test;
import com.agent.agent.VO.Blacklist;
import com.agent.agent.VO.Client;
import com.agent.agent.service.impl.AgentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ClientCtrlTest extends TestCase {

    @Mock
    private AgentServiceImpl agentService;

    @InjectMocks
    private ClientCtrl clientCtrl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void createCurrentUser() {
        Client client = new Client(); // Create a sample client object
        when(agentService.createClient(any(Client.class))).thenReturn(ResponseEntity.ok().build());

        // Act
        ResponseEntity<?> responseEntity = clientCtrl.createCurrentUser(client);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void verifyAccount() {
        // Arrange
        int id = 1;
        double amount = 100.0;
        when(agentService.VerifyAccount(eq(id), eq(amount))).thenReturn(ResponseEntity.ok().build());

        // Act
        ResponseEntity<?> responseEntity = clientCtrl.VerifyAccount(id, amount);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetCurrentUserByCin() {
        // Arrange
        String cin = "ABC123";
        when(agentService.getClientByCin(eq(cin))).thenReturn(ResponseEntity.ok().build());

        // Act
        ResponseEntity<?> responseEntity = clientCtrl.getCurrentUserByCin(cin);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    // Similar tests for other endpoints...

    @Test
    public void testCheckClientINBlacklist() {
        // Arrange
        Blacklist blacklist = new Blacklist(); // Create a sample blacklist object
        when(agentService.checkClientINBlacklist(any(Blacklist.class))).thenReturn(ResponseEntity.ok().build());

        // Act
        ResponseEntity<?> responseEntity = clientCtrl.checkClientINBlacklist(blacklist);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


}