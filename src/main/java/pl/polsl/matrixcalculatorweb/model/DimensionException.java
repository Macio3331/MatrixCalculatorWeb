// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

/**
 * A class in the 'model' package. The class extends the 'Exception' class. It
 * represents an exception used inside of the 'Calculator' class when dimensions
 * of matrixes do not match.
 *
 * @author Maciej-Musiał
 * @version 1.1
 */
public class DimensionException extends Exception {

    /**
     * Non-parameter constructor.
     */
    public DimensionException() {

    }

    /**
     * Exception class constructor.
     *
     * @param message display message
     */
    public DimensionException(String message) {
        super(message);
    }
}
