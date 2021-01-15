package com.paul.learning.wfh.controllers;

import com.paul.learning.wfh.config.WFHConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Class defining mapping for sorting
 */
@Controller
public class SortController {
    // private variables
    private static final Logger LOGGER = LoggerFactory.getLogger(SortController.class);

    // protected variables.
    protected static final String DEFAULT_SORT = "1234";

    @Autowired
    protected WFHConfig wfhConfig;

    @GetMapping("/sort")
    public String sort(@RequestParam(name="input", required = false, defaultValue = DEFAULT_SORT) String input, Model model) {
        String sortDefault = wfhConfig.getSortDefault();
        LOGGER.debug("Sort Default: {}", sortDefault);
        model.addAttribute("input", input);
        return "sort";
    }
}
