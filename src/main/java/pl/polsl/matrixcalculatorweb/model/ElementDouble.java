// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

/**
 * A class in the 'model' package. The class implements the
 * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} interface with
 * {@link java.lang.Double} type.
 *
 * @author Maciej-Musiał
 * @version 1.2
 */
public class ElementDouble implements IArithmetical<Double> {

    /**
     * Overridden method used to add two {@link java.lang.Double} values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return {@link java.lang.Double} object containing the result of addition
     * @throws DimensionException object when references are null
     */
    @Override
    public Double add(Double value1, Double value2) throws DimensionException {
        if (value1 == null || value2 == null) {
            throw new DimensionException("Wychwycono wartość null!");
        }
        return value1 + value2;
    }

    /**
     * Overridden method used to subtract two {@link java.lang.Double} values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return {@link java.lang.Double} object containing the result of
     * subtraction
     * @throws DimensionException object when references are null
     */
    @Override
    public Double subtract(Double value1, Double value2) throws DimensionException {
        if (value1 == null || value2 == null) {
            throw new DimensionException("Wychwycono wartość null!");
        }
        return value1 - value2;
    }

    /**
     * Overridden method used to multiply two {@link java.lang.Double} values.
     *
     * @param value1 first value
     * @param value2 second value
     * @return {@link java.lang.Double} object containing the result of
     * multiplication
     * @throws DimensionException object when references are null
     */
    @Override
    public Double multiply(Double value1, Double value2) throws DimensionException {
        if (value1 == null || value2 == null) {
            throw new DimensionException("Wychwycono wartość null!");
        }
        return value1 * value2;
    }
}
