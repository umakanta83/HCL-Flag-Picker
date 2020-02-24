package com.hcl.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FlagInfoControllerTest {

    @Autowired
    private MockMvc mvc;

    private final String jsonResult =
            "[\\r\\n        {\\r\\n            \\\"continent\\\": \\\"Africa\\\",\\r\\n                \\\"countries\\\": [\\r\\n            {\\r\\n                \\\"name\\\": \\\"Nigeria\\\",\\r\\n                    \\\"flag\\\": \\\"\\uD83C\\uDDF3\\uD83C\\uDDEC\\\"\\r\\n            },\\r\\n            {\\r\\n                \\\"name\\\": \\\"Ethiopia\\\",\\r\\n                    \\\"flag\\\": \\\"\\uD83C\\uDDEA\\uD83C\\uDDF9\\\"\\r\\n            },\\r\\n            {\\r\\n                \\\"name\\\": \\\"Egypt\\\",\\r\\n                    \\\"flag\\\": \\\"\\uD83C\\uDDEA\\uD83C\\uDDEC\\\"\\r\\n            },\\r\\n            {\\r\\n                \\\"name\\\": \\\"DR Congo\\\",\\r\\n                    \\\"flag\\\": \\\"\\uD83C\\uDDE8\\uD83C\\uDDE9\\\"\\r\\n            },\\r\\n            {\\r\\n                \\\"name\\\": \\\"South Africa\\\",\\r\\n                    \\\"flag\\\": \\\"\\uD83C\\uDDFF\\uD83C\\uDDE6\\\"\\r\\n            }\\r\\n\\t\\t]\\r\\n        }]";


    @Test
    public void getContinentTest() throws Exception {

        this.mvc.perform(get("/continents/America)")).andExpect(status().isOk())
                .andExpect(content().string(jsonResult));

    }

    @Test
    public void getContinentsTest() throws Exception {


        this.mvc.perform(get("/continents")).andExpect(status().isOk())
                .andExpect(content().string(jsonResult));
    }


}

