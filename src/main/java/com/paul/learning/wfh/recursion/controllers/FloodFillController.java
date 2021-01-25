package com.paul.learning.wfh.recursion.controllers;

import com.paul.learning.wfh.recursion.input.FloodFillInput;
import com.paul.learning.wfh.recursion.service.FloodFillService;
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

    @Autowired
    protected FloodFillService floodFillService;

    @PostMapping("/fill")
    public String fill(@RequestBody FloodFillInput input, Model model) {
        input = floodFillService.floodFill(input);
        model.addAttribute("input", input);
        return "fill";
    }

}
