package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AreaController.class)
public class AreaControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCircleArea() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "2");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("6.283185307179586")));
    }

    @Test
    public void testRectArea() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "2")
                .param("height", "3");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("6")));
    }
    @Test
    public void testError() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("width", "2")
                .param("height", "3");

        MockHttpServletRequestBuilder request2 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "2");
        MockHttpServletRequestBuilder request3 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("radius", "2");
        MockHttpServletRequestBuilder request4 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("invalid")));
        this.mvc.perform(request2)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("invalid")));
        this.mvc.perform(request3)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("invalid")));
        this.mvc.perform(request4)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("invalid")));
    }

}
