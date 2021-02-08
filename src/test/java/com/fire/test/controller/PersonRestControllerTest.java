package com.fire.test.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PersonRestControllerTest {

    public static final String NEW_USER = "{\"first_name\":\"pepe\",\"second_name\":\"mai\",\"age\":\"34\",\"favourite_colour\":\"yellow\"}";
    public static final String NEW_USERS = "[{\"first_name\":\"pepe\",\"second_name\":\"mai\",\"age\":\"34\",\"favourite_colour\":\"yellow\"}]";

    public static final String GET_POST_ENDPOINT = "/persons";
    public static final String DELETE_ENDPOINT = "/persons/1";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPersonAndRetrieveAndDeleteAPersonItIntegrationTest() throws Exception {

        this.mockMvc.perform(post(GET_POST_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(NEW_USER))
                .andExpect(status().isCreated())
                .andExpect(content().string(NEW_USER));

        this.mockMvc.perform(get(GET_POST_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(NEW_USERS));

        this.mockMvc.perform(delete(DELETE_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(NEW_USER))
                .andExpect(status().isOk());
    }
}