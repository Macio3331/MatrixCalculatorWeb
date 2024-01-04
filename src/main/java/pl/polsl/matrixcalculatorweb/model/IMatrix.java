// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

/**
 * An inteface in the 'model' package. It represents the matrix in any way
 * possible. The interface defines methods needed for classes implementing the
 * matrix concept.
 *
 * @param <T> generic type that can be stored inside matrix
 *
 * @author Maciej-Musiał
 * @version 1.2
 */
public interface IMatrix<T> {

    /**
     * Changes matrix's element to value passed by parameter on specified
     * position.
     *
     * @param column integer value representing a column
     * @param row integer value representing a row
     * @param value T object representing the value of that type
     * @throws DimensionException when refernces are null values or row and
     * column values are invalid
     */
    public void changeMatrixValue(int row, int column, T value) throws DimensionException;

    /**
     * Returns T object stored in passed position.
     *
     * @param column integer value representing a column
     * @param row integer value representing a row
     * @return T object stored in passed position
     * @throws DimensionException when refernces are null values or row and
     * column values are invalid
     */
    public T getMatrixValue(int column, int row) throws DimensionException;

    /**
     * Returns height of matrix object.
     *
     * @return height of matrix object
     */
    public int getHeight();

    /**
     * Returns width of matrix object.
     *
     * @return width of matrix object
     */
    public int getWidth();

    /**
     * Returns class type of T object.
     *
     * @return class type of T object
     */
    public Class<T> getClassType();
}
