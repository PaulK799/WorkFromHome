package com.paul.learning.wfh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class defining mapping for sorting
 */
@Controller
public class SortController {

    @GetMapping("/sort")
    public String sort(@RequestParam(name="input", required = false, defaultValue = "1234") String input, Model model) {
        model.addAttribute("input", input);
        return "sort";
    }
}
