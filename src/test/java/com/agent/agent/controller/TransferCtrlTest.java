package com.agent.agent.controller;

import static org.junit.Assert.*;
import com.agent.agent.VO.Multitransfer;
import com.agent.agent.VO.Transfer;
import com.agent.agent.service.impl.AgentServiceImpl;
import com.agent.agent.service.impl.AuthenticationServiceImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
public class TransferCtrlTest extends TestCase {
    @Mock
    private AgentServiceImpl agentService;

    @Mock
    private AuthenticationServiceImpl authenticationService;

    @InjectMocks
    private TransferCtrl transferCtrl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCreateMultitransferAgent_byCash() {
        // Arrange
        Multitransfer multitransfer = new Multitransfer();
        multitransfer.setTotal_amount(100.0f); // Set a non-null value for total_amount
        int agentId = 1;

        // Mock the necessary methods to avoid NPE
        when(agentService.createMultitransferAgent_byCash(eq(multitransfer))).thenReturn(ResponseEntity.ok().build());

        // Act
        ResponseEntity<?> responseEntity = transferCtrl.createMultitransferAgent_byCash(multitransfer, agentId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    public void testCreateMultitransferAgent() {
        // Arrange
        Multitransfer multitransfer = new Multitransfer(); // Create a sample multitransfer object
        int agentId = 1;
        when(agentService.createMultitransferAgent(any(Multitransfer.class))).thenReturn(ResponseEntity.ok().build());

        // Act
        ResponseEntity<?> responseEntity = transferCtrl.createMultitransferAgent(multitransfer, agentId);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    // Similar tests for other endpoints...

    @Test
    public void testCheckTransfer_code_pin() {
        // Arrange
        String reference = "12345";
        String pinCode = "6789";
        when(agentService.checkTransfer_code_pin(eq(reference), eq(pinCode))).thenReturn(ResponseEntity.ok().build());

        // Act
        ResponseEntity<?> responseEntity = transferCtrl.checkTransfer_code_pin(reference, pinCode);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}