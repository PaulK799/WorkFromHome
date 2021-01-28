package com.paul.learning.wfh.puzzles.sudoku.controllers;

import com.paul.learning.wfh.puzzles.sudoku.input.SudokuInput;
import com.paul.learning.wfh.puzzles.sudoku.services.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Class defining mapping for performing the Sudoku Solver Algorithm.
 */
@Controller
public class SudokuController {

    @Autowired
    protected SudokuService sudokuService;

    @PostMapping("/sudoku")
    public String sodoku(@RequestBody SudokuInput input, Model model) {
        input = sudokuService.solve(input);
        model.addAttribute("input", input);
        return "sudoku";
    }
}
