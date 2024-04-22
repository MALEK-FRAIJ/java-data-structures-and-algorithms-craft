/**
 * This is a package that contains classes to handle matrices groups of all types.
 * @author Malek Fraij
 * @version 1.8
 * @since 2023
  */
package collection.matrix;

/**
 * The Matrix class represents a mathematical matrix
 * It allows various operations and manipulations on matrices.
 * 
 * @author Malek
 * @version 1.8
 */
public class Matrix implements Sequences {

    /**
     * The 2D array representing the matrix
     */
    private double[][] matrix;

    /**
     * The number of rows in the matrix.
     * 
     */
    private int rows;

    /**
     * The number of columns in the matrix.
     */
    private int cols;

    /**
     * Constructs a Matrix object with the specified number of rows and columns.
     *
     * @param rows The number of rows in the matrix.
     * @param cols The number of columns in the matrix.
     * @throws ArrayIndexOutOfBoundsException if the rows or cols entered is out of
     *                                        range ({@code rows <= 0 || cols <= 0})
     */
    public Matrix(int rows, int cols) throws ArrayIndexOutOfBoundsException {

        if (rows <= 0 || cols <= 0) {
            throw new ArrayIndexOutOfBoundsException("Invalid row or column index");
        }

        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
    }

    /**
     * Gets the number of rows in the matrix.
     *
     * @return The number of rows.
     */
    public int getRows() {
        return rows;
    }

    /**
     * Gets the number of columns in the matrix.
     *
     * @return The number of columns.
     */
    public int getCols() {
        return cols;
    }

    /**
     * Sets the value at the specified row and column in the matrix.
     * 
     * @param row   The row index (0-based) where the value will be set
     * @param col   The column index (0-based) where the value will be set
     * @param value The value to be set at the specified position
     * @throws IllegalArgumentException if the row or column entered is out of range
     *                                  ({@code row <= 0 && row > rows && col <= 0 && col > cols})
     * @since 1.8
     */
    @Override
    public void setValue(int row, int col, double value) throws IllegalArgumentException {
        if (isEmpty() || row >= rows || col >= cols) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        matrix[row][col] = value;
    }

    /**
     * Gets the value at the specified row and column in the matrix.
     * 
     * @param row The row index (0-based) of the value to retrieve
     * @param col The column index (0-based) of the value to retrieve
     * @throws IllegalArgumentException if the row or column entered is out of range
     *                                  ({@code row <= 0 && row > rows && col <= 0 && col > cols})
     * @return The value at the specified position in the matrix
     * @since 1.0
     */
    @Override
    public double getValue(int row, int col) throws IllegalArgumentException {
        if ((isEmpty() || row >= rows || col >= cols)) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        return matrix[row][col];
    }

    /**
     * Retrieves the matrix stored within the object.
     *
     * @return A 2D array representing the matrix.
     */
    public double[][] getMatrix() {
        return matrix;
    }

    /**
     * Sets the matrix for the object to the provided 2D array.
     *
     * @param matrix A 2D array representing the new matrix.
     */
    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Tests if this matrix is empty.
     * 
     * @return {@code true} if and only if this matrix contains
     *         no items; {@code false} otherwise.
     */
    public boolean isEmpty() {
        return rows < 0 || cols < 0;
    }

}
