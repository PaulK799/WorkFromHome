package com.paul.learning.wfh.controllers;

import com.paul.learning.wfh.input.SortInput;
import com.paul.learning.wfh.services.impl.MergeSortService;
import com.paul.learning.wfh.services.impl.QuickSortService;
import com.paul.learning.wfh.services.impl.StandardSortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static com.paul.learning.wfh.input.SortType.MERGE;
import static com.paul.learning.wfh.input.SortType.QUICK;

/**
 * Class defining mapping for sorting
 */
@Controller
public class SortController {
    // private variables
    private static final Logger LOGGER = LoggerFactory.getLogger(SortController.class);

    @Autowired
    protected StandardSortService sortService;

    @Autowired
    protected MergeSortService mergeSortService;

    @Autowired
    protected QuickSortService quickSortService;

    /**
     * The GET Request for the sort endpoint.
     *
     * @param input - The {@link RequestParam} input being processed.
     * @param model - The {@link Model} being processed.
     * @return The Sort {@link Model} sort.
     */
    @GetMapping("/sort")
    public String sort(@RequestParam(name = "input", required = false, defaultValue = "${wfh.sort.default}") String input, Model model) {
        LOGGER.info("Sort Input Before : {}", input);
        String sortedInput = sortService.sort(input);
        LOGGER.info("Sort Input After : {}", sortedInput);
        model.addAttribute("input", sortedInput);
        return "sort";
    }

    /**
     * Define a POST endpoint using {@link SortInput} structure.
     *
     * @param input - The {@link SortInput} to be processed.
     * @param model - The {@link Model} being processed.
     * @return The Model sort.
     */
    @PostMapping("/sort")
    public String sort(@RequestBody SortInput input, Model model) {
        LOGGER.info("Sort Input Before : {}", input.getValue());
        String sortedInput;
        String value = input.getValue();

        String type = input.getType();
        if (MERGE.getType().equals(type)) {
            sortedInput = mergeSortService.sort(value);
        } else if (QUICK.getType().equals(type)) {
            sortedInput = quickSortService.sort(value);
        } else {
            sortedInput = sortService.sort(value);
        }

        LOGGER.info("Sort Input After : {}", sortedInput);
        model.addAttribute("input", sortedInput);
        return "sort";
    }
}
