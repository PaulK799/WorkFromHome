package com.paul.learning.wfh.mvc.floodfill.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.paul.learning.wfh.patterns.creational.prototype.Position;
import com.paul.learning.wfh.mvc.floodfill.input.FloodFillInput;
import com.paul.learning.wfh.mvc.floodfill.service.FloodFillService;
import com.paul.learning.wfh.mvc.sort.controllers.SortController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * A test for the {@link FloodFillController}.
 */
public class FloodFillControllerTest {

    @Spy
    private FloodFillService floodFillService;

    @InjectMocks
    private FloodFillController floodFillController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setupMocks() {
        // Sets the default view for the test.
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(floodFillController)
                .setViewResolvers(viewResolver)
                .build();
    }

    /**
     * Test the default ouput of the POST /sort endpoint defined in {@link SortController} using an undefined sort type.
     *
     * @throws Exception default exception handling.
     */
    @Test
    public void defaultFillPostTest() throws Exception {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        FloodFillInput input = new FloodFillInput();
        input.setImage(image);
        input.setPosition(new Position(1,1));
        input.setRed(0);
        input.setGreen(255);
        input.setBlue(0);
        input.setOriginalColor(1);
        input.setNewColor(2);

        int[][] expectedimage = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };

        // Serialize to JSON.
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(input);

        this.mockMvc.perform(post("/fill")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("fill"));
    }
}
