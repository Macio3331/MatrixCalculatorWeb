// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

/**
 * An inteface in the 'model' package. It is created due to lack of opportunity
 * to overload operators nor implementing interfaces by {@link java.lang.Number}
 * classes. The interface has 3 standard arithmetical operation: addition,
 * subtraction and multiplication.
 *
 * @param <T> generic type that is addable, subtractable and multipicable
 *
 * @author Maciej-Musiał
 * @version 1.2
 */
public interface IArithmetical<T> {

    /**
     * Method used to add two values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return T object containing the result of addition
     * @throws DimensionException object when references are null
     */
    public T add(T value1, T value2) throws DimensionException;

    /**
     * Method used to subtract two values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return T object containing the result of subtraction
     * @throws DimensionException object when references are null
     */
    public T subtract(T value1, T value2) throws DimensionException;

    /**
     * Method used to multiply two values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return T object containing the result of multiplication
     * @throws DimensionException object when references are null
     */
    public T multiply(T value1, T value2) throws DimensionException;
}
