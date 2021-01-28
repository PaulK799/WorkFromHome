package com.paul.learning.wfh.mvc.sort.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.paul.learning.wfh.config.WFHConfig;
import com.paul.learning.wfh.mvc.sort.input.SortInput;
import com.paul.learning.wfh.mvc.sort.input.SortType;
import com.paul.learning.wfh.mvc.sort.services.impl.MergeSortService;
import com.paul.learning.wfh.mvc.sort.services.impl.QuickSortService;
import com.paul.learning.wfh.mvc.sort.services.impl.StandardSortService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Test to verify the {@link SortController} being processed.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SortControllerTest {
    private static final String DEFAULT_VALUE = "1234";

    @Mock
    private WFHConfig wfhConfig;

    @Spy
    private StandardSortService sortService;

    @Spy
    private MergeSortService mergeSortService;

    @Spy
    private QuickSortService quickSortService;

    @InjectMocks
    private SortController sortController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setupMocks() {
        // Sets the default view for the test.
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        MockitoAnnotations.openMocks(this);
        when(wfhConfig.getSortDefault()).thenReturn(DEFAULT_VALUE);
        this.mockMvc = MockMvcBuilders.standaloneSetup(sortController)
                .setViewResolvers(viewResolver)
                .build();
    }


    /**
     * Test the default ouput of the GET /sort endpoint defined in {@link SortController}.
     *
     * @throws Exception default exception handling.
     */
    @Test
    public void testSortGET() throws Exception {
        this.mockMvc.perform(get("/sort")
                .param("input", DEFAULT_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("input", DEFAULT_VALUE))
                .andExpect(view().name("sort"));
    }

    /**
     * Test the default ouput of the POST /sort endpoint defined in {@link SortController} using an undefined sort type.
     *
     * @throws Exception default exception handling.
     */
    @Test
    public void testDefaultSortPOST() throws Exception {
        SortInput input = new SortInput();
        input.setValue(DEFAULT_VALUE);
        input.setType("blah");

        // Serialize to JSON.
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(input);

        this.mockMvc.perform(post("/sort")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("input", DEFAULT_VALUE))
                .andExpect(view().name("sort"));
    }

    /**
     * Test the ouput of the POST /sort endpoint defined in {@link SortController} using Merge sort.
     *
     * @throws Exception default exception handling.
     */
    @Test
    public void testMergeSortPOST() throws Exception {
        SortInput input = new SortInput();
        input.setValue("5432");
        input.setType(SortType.MERGE.getType());

        // Serialize to JSON.
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(input);

        this.mockMvc.perform(post("/sort")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("input", "2345"))
                .andExpect(view().name("sort"));
    }
}
