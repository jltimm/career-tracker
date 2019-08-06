package com.jlt.careertracker.controllers;

import com.jlt.careertracker.repositories.CareerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CareerControllerTest {

    /**
     * Mock REST API
     */
    private MockMvc mockMvc;

    /**
     * The career repository
     */
    @Autowired
    private CareerRepository careerRepository;

    /**
     * Set up the testing environment
     */
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new CareerController(careerRepository))
                .alwaysExpect(forwardedUrl(null))
                .build();
    }

    @Test
    public void shouldReturn200OK() throws Exception {
        mockMvc.perform(get("/careers"))
                .andExpect(status().isOk());
    }
}