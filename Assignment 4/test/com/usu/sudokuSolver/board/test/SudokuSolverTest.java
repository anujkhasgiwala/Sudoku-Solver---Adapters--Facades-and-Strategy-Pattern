package com.usu.sudokuSolver.board.test;

import com.usu.sudokuSolver.board.SudokuBoard;
import com.usu.sudokuSolver.solution.RecursiveBruteSudokuSolver;
import com.usu.sudokuSolver.template.SudokuSolver;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SudokuSolverTest {

    String[][] sudoku = {
    		{"8","6","-","-","2","-","-","-","-"},
    		{"-","-","-","7","-","-","-","5","9"},
    		{"-","-","-","-","-","-","-","-","-"},
    		{"-","-","-","-","6","-","8","-","-"},
    		{"-","4","-","-","-","-","-","-","-"},
    		{"-","-","5","3","-","-","-","-","7"},
    		{"-","-","-","-","-","-","-","-","-"},
    		{"-","2","-","-","-","-","6","-","-"},
    		{"-","-","7","5","-","9","-","-","-"}
    };

    private String[] sortedLine = {"1","2","3","4","5","6","7","8","9"};

    SudokuBoard sb = new SudokuBoard(sudoku);
    RecursiveBruteSudokuSolver ss = new RecursiveBruteSudokuSolver(sb);
    
    @Test(expected = NullPointerException.class)
    public void testIsSolved_NullValues() {
    	Integer row = null, col = null;
    	ss.solve(row, col);
    }
    
    @Test
    public void testIsSolved_Correct() {
    	SudokuSolver.symbols = sortedLine;
    	ss.solve(0, 0);
        for (int i = 0; i < 9; i++) {
            assertTrue(arrayPassed(sb.getRow(i)));
            assertTrue(arrayPassed(sb.getColumn(i)));
        }

    }

    private boolean arrayPassed(String[] toVerify) {
        String[] copy = Arrays.copyOf(toVerify, 9);
        Arrays.sort(copy);
        return Arrays.equals(sortedLine, copy);
    }
}