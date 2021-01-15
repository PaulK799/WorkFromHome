package com.paul.learning.wfh.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.paul.learning.wfh.controllers.SortController.DEFAULT_SORT;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test to verify the {@link SortController} being processed.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SortControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test the default output of the /sort endpoint defined in {@link SortController}.
     *
     * @throws Exception default exception handling.
     */
    @Test
    public void testSortDefaultOutput() throws Exception {
        this.mockMvc.perform(get("/sort"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(DEFAULT_SORT)));
    }
}
