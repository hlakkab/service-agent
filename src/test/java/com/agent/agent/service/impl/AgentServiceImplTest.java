package com.agent.agent.service.impl;

import static org.junit.Assert.*;
import com.agent.agent.VO.Blacklist;
import com.agent.agent.VO.Client;
import com.agent.agent.VO.Multitransfer;
import com.agent.agent.VO.Transfer;
import com.agent.agent.handler.RestTemplateResponseErrorHandler;
import com.agent.agent.modele.Agent;
import com.agent.agent.modele.Solde;
import com.agent.agent.repository.AgentRepository;
import com.agent.agent.service.impl.SoldeServiceImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AgentServiceImplTest extends TestCase {
    private AgentServiceImpl agentService;

    @Mock
    private AgentRepository agentRepository;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private SoldeServiceImpl soldeService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        agentService = new AgentServiceImpl();
    }
    @Test
    public void testCreateAgent() {

    }

}