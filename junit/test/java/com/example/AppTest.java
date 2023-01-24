package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test //getsAllDonor
    public void test_case1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/donor")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test //getsSingleDonor
    public void test_case2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/donor/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    
   @Test //delete Donor
    public void test_case3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/sample/1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test //returnsNotFoundForInvalidSingleDonor
    public void test_case4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/donor/100")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}





