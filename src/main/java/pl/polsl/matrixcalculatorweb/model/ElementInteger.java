// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

/**
 * A class in the 'model' package. The class implements the
 * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} interface with
 * {@link java.lang.Integer} type.
 *
 * @author Maciej-Musiał
 * @version 1.2
 */
public class ElementInteger implements IArithmetical<Integer> {

    /**
     * Overridden method used to add two {@link java.lang.Integer} values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return {@link java.lang.Integer} object containing the result of
     * addition
     * @throws DimensionException object when references are null
     */
    @Override
    public Integer add(Integer value1, Integer value2) throws DimensionException {
        if (value1 == null || value2 == null) {
            throw new DimensionException("Wychwycono wartość null!");
        }
        return value1 + value2;
    }

    /**
     * Overridden method used to subtract two {@link java.lang.Integer} values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return {@link java.lang.Integer} object containing the result of
     * subtraction
     * @throws DimensionException object when references are null
     */
    @Override
    public Integer subtract(Integer value1, Integer value2) throws DimensionException {
        if (value1 == null || value2 == null) {
            throw new DimensionException("Wychwycono wartość null!");
        }
        return value1 - value2;
    }

    /**
     * Overridden method used to multiply two {@link java.lang.Integer} values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return {@link java.lang.Integer} object containing the result of
     * multiplication
     * @throws DimensionException object when references are null
     */
    @Override
    public Integer multiply(Integer value1, Integer value2) throws DimensionException {
        if (value1 == null || value2 == null) {
            throw new DimensionException("Wychwycono wartość null!");
        }
        return value1 * value2;
    }
}
