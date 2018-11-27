package com.example.demo;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(VehiclesController.class)
public class VehiclesControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testVehiclesQuery()throws Exception{
        this.mvc.perform(get("/vehicles?year=1987&number-doors=2"))
                .andExpect(status().isOk());
    }
}
