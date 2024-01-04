// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

// packages containing class definitions
import java.lang.reflect.InvocationTargetException;

/**
 * A class in the 'model' package. The class represents a module responsible for
 * operating on matrixes.
 *
 * @author Maciej-Musiał
 * @version 2.3
 */
public class Calculator {

    /**
     * Non-parameter Calculator constructor.
     */
    public Calculator() {
    }

    /**
     * Adds two matrixes of any number types passed as parameters.Returns new
     * object implementing {@link pl.polsl.matrixcalculatorweb.model.IMatrix}
     * interface of passed number type as a result of addition.
     *
     * @param <T> generic type of class extending {@link java.lang.Number} class
     * @param <K> generic type of class implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface
     * @param m1 object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - first matrix
     * @param m2 object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - second matrix
     * @param operation object representing the type number of matrix and
     * implementing {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} interface
     * @return new object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - matrix
     * containing a result of addition
     * @throws DimensionException object when dimensions of matrices do not
     * match, references are null values or there is no valid constructor
     */
    public <T extends Number, K extends IMatrix<T>> K addMatrices(K m1, K m2, IArithmetical<T> operation) throws DimensionException {
        if (m1 == null || m2 == null || operation == null) {
            throw new DimensionException("Niezainicjalizowana wartość parametru!");
        } else if (m1.getHeight() != m2.getHeight() || m1.getWidth() != m2.getWidth()) {
            throw new DimensionException("Niedozwolone wymiary macierzy do wykonania operacji dodawania!");
        }

        try {
            K m = (K) m1.getClass().getConstructor(int.class, int.class, m1.getClassType().getClass()).newInstance(m1.getHeight(), m1.getWidth(), m1.getClassType());
            for (int i = 0; i < m.getHeight(); i++) {
                for (int j = 0; j < m.getWidth(); j++) {
                    m.changeMatrixValue(i, j, operation.add(m1.getMatrixValue(i, j), m2.getMatrixValue(i, j)));
                }
            }
            return m;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new DimensionException("Niepoprawne wywołanie konstruktora!");
        } catch (DimensionException e) {
            throw e;
        }

    }

    /**
     * Subtracts two matrixes of any number types passed as parameters.Returns
     * new object implementing {@link pl.polsl.matrixcalculatorweb.model.IMatrix}
     * interface of passed number type as a result of subtraction.
     *
     * @param <T> generic type of class extending {@link java.lang.Number} class
     * @param <K> generic type of class implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface
     * @param m1 object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - first matrix
     * @param m2 object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - second matrix
     * @param operation object representing the type number of matrix and
     * implementing {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} interface
     * @return new object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - matrix
     * containing a result of subtraction
     * @throws DimensionException object when dimensions of matrices do not
     * match, references are null values or there is no valid constructor
     */
    public <T extends Number, K extends IMatrix<T>> K substractMatrices(K m1, K m2, IArithmetical<T> operation) throws DimensionException {
        if (m1 == null || m2 == null || operation == null) {
            throw new DimensionException("Niezainicjalizowana wartość parametru!");
        } else if (m1.getHeight() != m2.getHeight() || m1.getWidth() != m2.getWidth()) {
            throw new DimensionException("Niedozwolone wymiary macierzy do wykonania operacji odejmowania!");
        }

        try {
            K m = (K) m1.getClass().getConstructor(int.class, int.class, m1.getClassType().getClass()).newInstance(m1.getHeight(), m1.getWidth(), m1.getClassType());
            for (int i = 0; i < m.getHeight(); i++) {
                for (int j = 0; j < m.getWidth(); j++) {
                    m.changeMatrixValue(i, j, operation.subtract(m1.getMatrixValue(i, j), m2.getMatrixValue(i, j)));
                }
            }
            return m;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new DimensionException("Niepoprawne wywołanie konstruktora!");
        } catch (DimensionException e) {
            throw e;
        }
    }

    /**
     * Multiplies two matrixes of any number types passed as parameters.Returns
     * new object implementing {@link pl.polsl.matrixcalculatorweb.model.IMatrix}
     * interface of passed number type as a result of multiplication.
     *
     * @param <T> generic type of class extending {@link java.lang.Number} class
     * @param <K> generic type of class implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface
     * @param m1 object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - first matrix
     * @param m2 object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - second matrix
     * @param operation object representing the type number of matrix and
     * implementing {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} interface
     * @return new object of K generic type implementing
     * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface - matrix
     * containing a result of multiplication
     * @throws DimensionException object when dimensions of matrices do not
     * match, references are null values or there is no valid constructor
     */
    public <T extends Number, K extends IMatrix<T>> K multiplyMatrices(K m1, K m2, IArithmetical<T> operation) throws DimensionException {
        if (m1 == null || m2 == null || operation == null) {
            throw new DimensionException("Niezainicjalizowana wartość parametru!");
        } else if (m1.getWidth() != m2.getHeight()) {
            throw new DimensionException("Niedozwolone wymiary macierzy do wykonania operacji mnożenia!");
        }

        try {
            K m = (K) m1.getClass().getConstructor(int.class, int.class, m1.getClassType().getClass()).newInstance(m1.getHeight(), m2.getWidth(), m1.getClassType());
            for (int i = 0; i < m.getHeight(); i++) {
                for (int j = 0; j < m.getWidth(); j++) {
                    T partialSum = m1.getClassType().getConstructor(String.class).newInstance("0");
                    for (int k = 0; k < m1.getWidth(); k++) {
                        partialSum = operation.add(partialSum, operation.multiply(m1.getMatrixValue(i, k), m2.getMatrixValue(k, j)));
                    }
                    m.changeMatrixValue(i, j, partialSum);
                }
            }
            return m;
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new DimensionException("Niepoprawne wywołanie konstruktora!");
        } catch (DimensionException e) {
            throw e;
        }
    }
}
