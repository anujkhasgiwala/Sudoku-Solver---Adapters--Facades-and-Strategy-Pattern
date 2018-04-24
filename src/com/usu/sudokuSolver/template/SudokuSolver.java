package com.usu.sudokuSolver.template;

/**
 * @author Anuj Khasgiwala
 *
 */
public abstract class SudokuSolver {
	
	public static String outputFileName = null;
	
	public static String[] symbols = null;

    protected abstract boolean solve(int row, int column);
}
