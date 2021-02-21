package com.kvks.demo;

import com.kvks.demo.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentServiceImpl studentServiceImpl;

   /* @Test
    public void testGetStudents() throws Exception{

        MvcResult response = mockMvc.perform(get("/students/")).andExpect(status().isOk()).andReturn();
        //String res = response.getResponse().getContentAsString();
        //assertEquals(strNow, res);
    }*/

}
