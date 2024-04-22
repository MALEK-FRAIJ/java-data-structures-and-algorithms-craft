package collection.matrix;

public interface Sequences {

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
    public void setValue(int row, int col, double value);

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
    public double getValue(int row, int col);

}
