package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPiGET() throws Exception{
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testCalcs() throws Exception{
        this.mvc.perform(get("/math/calculate?operation=divide&x=1&y=0 ").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("impossibru!"));
        this.mvc.perform(get("/math/calculate?operation=add&x=1&y=3 ").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("4.0"));
        this.mvc.perform(get("/math/calculate?operation=subtract&x=-1&y=3 ").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("-4.0"));
        this.mvc.perform(get("/math/calculate?operation=multiply&x=-1&y=3 ").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("-3.0"));
    }

    @Test
    public void testSums() throws Exception{
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }
}
