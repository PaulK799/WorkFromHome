package com.paul.learning.wfh.recursion.controllers;

import com.paul.learning.wfh.recursion.input.FloodFillInput;
import com.paul.learning.wfh.recursion.service.FloodFillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Class defining mapping for performing the Flood Fill Algorithm.
 */
@Controller
public class FloodFillController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FloodFillController.class);

    @Autowired
    FloodFillService floodFillService;

    @PostMapping("/fill")
    public String fill(@RequestBody FloodFillInput input, Model model) {
        input = floodFillService.floodFill(input);
        model.addAttribute("input", input);
        return "fill";
    }

}
