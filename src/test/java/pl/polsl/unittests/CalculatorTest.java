// definition of the package in which class is placed
package pl.polsl.unittests;

// packages containing class definitions 
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.api.Test;
import pl.polsl.matrixcalculatorweb.model.Calculator;
import pl.polsl.matrixcalculatorweb.model.DimensionException;
import pl.polsl.matrixcalculatorweb.model.ElementDouble;
import pl.polsl.matrixcalculatorweb.model.ElementInteger;

/**
 * Class made for {@link pl.polsl.matrixcalculatorweb.model.Calculator}'s methods
 * testing.
 *
 * @author Maciej-Musiał
 * @version 2.1
 */
public class CalculatorTest {

    /**
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} object which methods are
     * tested.
     */
    private Calculator calculator;

    /**
     * {@link pl.polsl.matrixcalculatorweb.model.ElementDouble} object needed as
     * methods' parameter.
     */
    private ElementDouble elementDouble;

    /**
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} object needed as
     * methods' parameter.
     */
    private ElementInteger elementInteger;

    /**
     * Method that is being executed before each test. It initializes fields
     * created in this class.
     */
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        elementDouble = new ElementDouble();
        elementInteger = new ElementInteger();
    }

    /**
     * Method used to provide parameters for addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockDouble} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockDouble} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForAddMatrices() {
        return Stream.of(
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(2, 3, Double.class, -2.0), new MockDouble(2, 3, Double.class, -1.0)),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(2, 3, Double.class, 2.0), new MockDouble(2, 3, Double.class, 3.0)),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(2, 3, Double.class, 0.0), new MockDouble(2, 3, Double.class, 1.0)),
                Arguments.of(new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 2.0))
        );
    }

    /**
     * Test of addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix containing the correct result of addition
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForAddMatrices")
    void parameterizedTestDoubleAddMatrices(MockDouble matrix1, MockDouble matrix2, MockDouble result) {
        try {
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.addMatrices(matrix1, matrix2, elementDouble).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockInteger} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockInteger} object
     */
    private static Stream<Arguments> provideMatrixIntParametersForAddMatrices() {
        return Stream.of(
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(2, 3, Integer.class, -2), new MockInteger(2, 3, Integer.class, -1)),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(2, 3, Integer.class, 2), new MockInteger(2, 3, Integer.class, 3)),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(2, 3, Integer.class, 0), new MockInteger(2, 3, Integer.class, 1)),
                Arguments.of(new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 2))
        );
    }

    /**
     * Test of addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix containing the correct result of addition
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForAddMatrices")
    void parameterizedTestIntAddMatrices(MockInteger matrix1, MockInteger matrix2, MockInteger result) {
        try {
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.addMatrices(matrix1, matrix2, elementInteger).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockDouble} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockDouble} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForSubstractMatrices() {
        return Stream.of(
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(2, 3, Double.class, -2.0), new MockDouble(2, 3, Double.class, 3.0)),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(2, 3, Double.class, 2.0), new MockDouble(2, 3, Double.class, -1.0)),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(2, 3, Double.class, 0.0), new MockDouble(2, 3, Double.class, 1.0)),
                Arguments.of(new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 0.0))
        );
    }

    /**
     * Test of substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix containing the correct result of substraction
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForSubstractMatrices")
    void parameterizedTestDoubleSubstractMatrices(MockDouble matrix1, MockDouble matrix2, MockDouble result) {
        try {
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.substractMatrices(matrix1, matrix2, elementDouble).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockInteger} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockInteger} object
     */
    private static Stream<Arguments> provideMatrixIntParametersForSubstractMatrices() {
        return Stream.of(
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(2, 3, Integer.class, -2), new MockInteger(2, 3, Integer.class, 3)),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(2, 3, Integer.class, 2), new MockInteger(2, 3, Integer.class, -1)),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(2, 3, Integer.class, 0), new MockInteger(2, 3, Integer.class, 1)),
                Arguments.of(new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 0))
        );
    }

    /**
     * Test of substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix containing the correct result of substraction
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForSubstractMatrices")
    void parameterizedTestIntSubstractMatrices(MockInteger matrix1, MockInteger matrix2, MockInteger result) {
        try {
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.substractMatrices(matrix1, matrix2, elementInteger).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockDouble} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockDouble} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForSimpleMultiplyMatrices() {
        return Stream.of(
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(3, 2, Double.class, -2.0), new MockDouble(2, 2, Double.class, -6.0)),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(3, 2, Double.class, 2.0), new MockDouble(2, 2, Double.class, 6.0)),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(3, 2, Double.class, 0.0), new MockDouble(2, 2, Double.class, 0.0)),
                Arguments.of(new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 1.0))
        );
    }

    /**
     * Test of multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix containing the correct result of
     * multiplication
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForSimpleMultiplyMatrices")
    void parameterizedTestDoubleSimpleMultiplyMatrices(MockDouble matrix1, MockDouble matrix2, MockDouble result) {
        try {
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.multiplyMatrices(matrix1, matrix2, elementDouble).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockInteger} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockInteger} object
     */
    private static Stream<Arguments> provideMatrixIntParametersForSimpleMultiplyMatrices() {
        return Stream.of(
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(3, 2, Integer.class, -2), new MockInteger(2, 2, Integer.class, -6)),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(3, 2, Integer.class, 2), new MockInteger(2, 2, Integer.class, 6)),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(3, 2, Integer.class, 0), new MockInteger(2, 2, Integer.class, 0)),
                Arguments.of(new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 1))
        );
    }

    /**
     * Test of multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix containing the correct result of
     * multiplication
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForSimpleMultiplyMatrices")
    void parameterizedTestIntSimpleMultiplyMatrices(MockInteger matrix1, MockInteger matrix2, MockInteger result) {
        try {
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.multiplyMatrices(matrix1, matrix2, elementInteger).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockDouble} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result. The method returns arguments that have different
     * elements' values inside.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockDouble} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForMultiplyMatrices() {
        MockDouble a = new MockDouble(2, 2, Double.class, -4.0);
        MockDouble b = new MockDouble(2, 2, Double.class, 4.0);
        try {
            a.changeMatrixValue(1, 0, -6.0);
            a.changeMatrixValue(1, 1, -6.0);
            b.changeMatrixValue(1, 0, 6.0);
            b.changeMatrixValue(1, 1, 6.0);
        } catch (DimensionException e) {
        }
        return Stream.of(
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(3, 2, Double.class, -2.0), a),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(3, 2, Double.class, 2.0), b),
                Arguments.of(new MockDouble(2, 3, Double.class, 1.0), new MockDouble(3, 2, Double.class, 0.0), new MockDouble(2, 2, Double.class, 0.0)),
                Arguments.of(new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 1.0), new MockDouble(1, 1, Double.class, 0.0))
        );
    }

    /**
     * Test of addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests situation
     * when each element of matrix stores different value.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix containing the correct result of addition
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForMultiplyMatrices")
    void parameterizedTestDoubleMultiplyMatrices(MockDouble matrix1, MockDouble matrix2, MockDouble result) {
        try {
            matrix1.changeMatrixValue(0, 0, 0.0);
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.multiplyMatrices(matrix1, matrix2, elementDouble).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates three
     * {@link pl.polsl.unittests.MockInteger} objects inside of every
     * argument - first two are arguments of testing method and third represents
     * the correct result. The method returns arguments that have different
     * elements' values inside.
     *
     * @return stream of arguments which each consist three
     * {@link pl.polsl.unittests.MockInteger} object
     */
    private static Stream<Arguments> provideMatrixIntParametersForMultiplyMatrices() {
        MockInteger a = new MockInteger(2, 2, Integer.class, -4);
        MockInteger b = new MockInteger(2, 2, Integer.class, 4);
        try {
            a.changeMatrixValue(1, 0, -6);
            a.changeMatrixValue(1, 1, -6);
            b.changeMatrixValue(1, 0, 6);
            b.changeMatrixValue(1, 1, 6);
        } catch (DimensionException e) {
        }
        return Stream.of(
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(3, 2, Integer.class, -2), a),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(3, 2, Integer.class, 2), b),
                Arguments.of(new MockInteger(2, 3, Integer.class, 1), new MockInteger(3, 2, Integer.class, 0), new MockInteger(2, 2, Integer.class, 0)),
                Arguments.of(new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 1), new MockInteger(1, 1, Integer.class, 0))
        );
    }

    /**
     * Test of multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests situation
     * when each element of matrix stores different value.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param result third {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix containing the correct result of addition
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForMultiplyMatrices")
    void parameterizedTestIntMultiplyMatrices(MockInteger matrix1, MockInteger matrix2, MockInteger result) {
        try {
            matrix1.changeMatrixValue(0, 0, 0);
            for (int i = 0; i < result.getHeight(); i++) {
                assertArrayEquals(calculator.multiplyMatrices(matrix1, matrix2, elementInteger).getMatrixValues()[i], result.getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
            }
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates two
     * {@link pl.polsl.unittests.MockDouble} and one
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects inside of
     * every argument - all being arguments of testing method. It produces the
     * incorrect data for this method.
     *
     * @return stream of arguments which each consist two
     * {@link pl.polsl.unittests.MockDouble} and
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForAddMatricesException() {
        return Stream.of(
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(2, 4, Double.class), new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(3, 3, Double.class), new ElementDouble()),
                Arguments.of(null, new MockDouble(2, 3, Double.class), new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), null, new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(2, 3, Double.class), null)
        );
    }

    /**
     * Test of addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param element {@link pl.polsl.matrixcalculatorweb.model.ElementDouble} object
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForAddMatricesException")
    void parameterizedTestDoubleAddMatricesException(MockDouble matrix1, MockDouble matrix2, ElementDouble element) {
        try {
            calculator.addMatrices(matrix1, matrix2, element);
            fail("Wrong dimensions exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates two
     * {@link pl.polsl.unittests.MockInteger} and one
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects inside of
     * every argument - all being arguments of testing method. It produces the
     * incorrect data for this method.
     *
     * @return stream of arguments which each consist two
     * {@link pl.polsl.unittests.MockInteger} and
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects
     */
    private static Stream<Arguments> provideMatrixIntParametersForAddMatricesException() {
        return Stream.of(
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(2, 4, Integer.class), new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(3, 3, Integer.class), new ElementInteger()),
                Arguments.of(null, new MockInteger(2, 3, Integer.class), new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), null, new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(2, 3, Integer.class), null)
        );
    }

    /**
     * Test of addMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param element {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} object
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForAddMatricesException")
    void parameterizedTestIntAddMatricesException(MockInteger matrix1, MockInteger matrix2, ElementInteger element) {
        try {
            calculator.addMatrices(matrix1, matrix2, element);
            fail("Wrong dimensions exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates two
     * {@link pl.polsl.unittests.MockDouble} and one
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects inside of
     * every argument - all being arguments of testing method. It produces the
     * incorrect data for this method.
     *
     * @return stream of arguments which each consist two
     * {@link pl.polsl.unittests.MockDouble} and
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForSubstractMatricesException() {
        return Stream.of(
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(2, 4, Double.class), new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(3, 3, Double.class), new ElementDouble()),
                Arguments.of(null, new MockDouble(2, 3, Double.class), new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), null, new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(2, 3, Double.class), null)
        );
    }

    /**
     * Test of substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param element {@link pl.polsl.matrixcalculatorweb.model.ElementDouble} object
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForSubstractMatricesException")
    void parameterizedTestDoubleSubstractMatricesException(MockDouble matrix1, MockDouble matrix2, ElementDouble element) {
        try {
            calculator.substractMatrices(matrix1, matrix2, element);
            fail("Wrong dimensions exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates two
     * {@link pl.polsl.unittests.MockInteger} and one
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects inside of
     * every argument - all being arguments of testing method. It produces the
     * incorrect data for this method.
     *
     * @return stream of arguments which each consist two
     * {@link pl.polsl.unittests.MockInteger} and
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects
     */
    private static Stream<Arguments> provideMatrixIntParametersForSubstractMatricesException() {
        return Stream.of(
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(2, 4, Integer.class), new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(3, 3, Integer.class), new ElementInteger()),
                Arguments.of(null, new MockInteger(2, 3, Integer.class), new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), null, new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(2, 3, Integer.class), null)
        );
    }

    /**
     * Test of substractMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param element {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} object
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForSubstractMatricesException")
    void parameterizedTestIntSubstractMatricesException(MockInteger matrix1, MockInteger matrix2, ElementInteger element) {
        try {
            calculator.substractMatrices(matrix1, matrix2, element);
            fail("Wrong dimensions exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates two
     * {@link pl.polsl.unittests.MockDouble} and one
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects inside of
     * every argument - all being arguments of testing method. It produces the
     * incorrect data for this method.
     *
     * @return stream of arguments which each consist two
     * {@link pl.polsl.unittests.MockDouble} and
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForMultiplyMatricesException() {
        return Stream.of(
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(2, 4, Double.class), new ElementDouble()),
                Arguments.of(null, new MockDouble(2, 3, Double.class), new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), null, new ElementDouble()),
                Arguments.of(new MockDouble(2, 3, Double.class), new MockDouble(2, 3, Double.class), null)
        );
    }

    /**
     * Test of multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockDouble}
     * object iimitating a matrix
     * @param element {@link pl.polsl.matrixcalculatorweb.model.ElementDouble} object
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForMultiplyMatricesException")
    void parameterizedTestDoubleMultiplyMatricesException(MockDouble matrix1, MockDouble matrix2, ElementDouble element) {
        try {
            calculator.multiplyMatrices(matrix1, matrix2, element);
            fail("Wrong dimensions exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It creates two
     * {@link pl.polsl.unittests.MockInteger} and one
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects inside of
     * every argument - all being arguments of testing method. It produces the
     * incorrect data for this method.
     *
     * @return stream of arguments which each consist two
     * {@link pl.polsl.unittests.MockInteger} and
     * {@link pl.polsl.matrixcalculatorweb.model.IArithmetical} objects
     */
    private static Stream<Arguments> provideMatrixIntParametersForMultiplyMatricesException() {
        return Stream.of(
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(2, 4, Integer.class), new ElementInteger()),
                Arguments.of(null, new MockInteger(2, 3, Integer.class), new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), null, new ElementInteger()),
                Arguments.of(new MockInteger(2, 3, Integer.class), new MockInteger(2, 3, Integer.class), null)
        );
    }

    /**
     * Test of multiplyMatrices method of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculator} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param matrix1 first {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param matrix2 second {@link pl.polsl.unittests.MockInteger}
     * object iimitating a matrix
     * @param element {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} object
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForMultiplyMatricesException")
    void parameterizedTestIntMultiplyMatricesException(MockInteger matrix1, MockInteger matrix2, ElementInteger element) {
        try {
            calculator.multiplyMatrices(matrix1, matrix2, element);
            fail("Wrong dimensions exception was not catched!");
        } catch (DimensionException e) {
        }
    }

//    private MockDouble matrixDouble3;
//    private MockDouble matrixDouble3;
//    private MockDouble matrixDouble4;
//    private MockDouble matrixDouble5;
//    private MockInteger matrixInteger1;
//    private MockInteger matrixInteger2;
//    private MockInteger matrixInteger3;
//    private MockInteger matrixInteger4;
//    private MockInteger matrixInteger5;
//    @Test
//    public void testAddMatrices()  {
//        matrixDouble2 = new MockDouble(2, 3, Double.class, -2.0);
//        matrixInteger2 = new MockInteger(2, 3, Integer.class, -2);
//        
//        try {
//            for(int i = 0; i < matrixDouble1.getHeight(); i++) {
//                assertArrayEquals(calculator.addMatrices(matrixDouble1, matrixDouble2, new ElementDouble()).getMatrixValues()[i], new MockDouble(2, 3, Double.class, -1.0).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//            for(int i = 0; i < matrixInteger1.getHeight(); i++) {
//                assertArrayEquals(calculator.addMatrices(matrixInteger1, matrixInteger2, new ElementInteger()).getMatrixValues()[i], new MockInteger(2, 3, Integer.class, -1).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//        } catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//    }
//    @Test
//    public void testSubstractMatrices() {
//        matrixDouble2 = new MockDouble(2, 3, Double.class, -2.0);
//        matrixInteger2 = new MockInteger(2, 3, Integer.class, -2);
//        
//        try {
//            for(int i = 0; i < matrixDouble1.getHeight(); i++) {
//                assertArrayEquals(calculator.substractMatrices(matrixDouble1, matrixDouble2, new ElementDouble()).getMatrixValues()[i], new MockDouble(2, 3, Double.class, 3.0).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//            for(int i = 0; i < matrixInteger1.getHeight(); i++) {
//                assertArrayEquals(calculator.substractMatrices(matrixInteger1, matrixInteger2, new ElementInteger()).getMatrixValues()[i], new MockInteger(2, 3, Integer.class, 3).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//        } catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//    }
//    @Test
//    public void testMultiplyMatrices() {
//        matrixDouble3 = new MockDouble(3, 2, Double.class);
//        matrixInteger3 = new MockInteger(3, 2, Integer.class);
//        
//        try {
//            for(int i = 0; i < matrixDouble1.getHeight(); i++) {
//                assertArrayEquals(calculator.multiplyMatrices(matrixDouble1, matrixDouble3, new ElementDouble()).getMatrixValues()[i], new MockDouble(2, 2, Double.class, 0.0).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//            for(int i = 0; i < matrixDouble1.getHeight(); i++) {
//                assertArrayEquals(calculator.multiplyMatrices(matrixDouble3, matrixDouble1, new ElementDouble()).getMatrixValues()[i], new MockDouble(3, 3, Double.class, 0.0).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//            for(int i = 0; i < matrixInteger1.getHeight(); i++) {
//                assertArrayEquals(calculator.multiplyMatrices(matrixInteger1, matrixInteger3, new ElementInteger()).getMatrixValues()[i], new MockInteger(2, 2, Integer.class, 0).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//            for(int i = 0; i < matrixInteger1.getHeight(); i++) {
//                assertArrayEquals(calculator.multiplyMatrices(matrixInteger3, matrixInteger1, new ElementInteger()).getMatrixValues()[i], new MockInteger(3, 3, Integer.class, 0).getMatrixValues()[i], "The sum of " + i + " rows of matrices did not match!");
//            }
//        } catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//    }
//    @Test
//    public void testAddMatricesException() {
//        matrixDouble4 = new MockDouble(2, 4, Double.class, 3.0);
//        matrixDouble5 = new MockDouble(3, 3, Double.class, -3.0);
//        matrixInteger4 = new MockInteger(2, 4, Integer.class, 3);
//        matrixInteger5 = new MockInteger(3, 3, Integer.class, -3);
//        
//        try {
//            calculator.addMatrices(matrixDouble1, matrixDouble4, new ElementDouble());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(matrixDouble1, matrixDouble5, new ElementDouble());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(matrixDouble1, matrixDouble4, null);
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(matrixDouble1, null, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(null, matrixDouble2, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(null, null, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(matrixInteger1, matrixInteger4, new ElementInteger());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(matrixInteger1, matrixInteger5, new ElementInteger());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(matrixInteger1, matrixInteger4, null);
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(matrixInteger1, null, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(null, matrixInteger2, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.addMatrices(null, null, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//    }
//    @Test
//    public void testSubstractMatricesException() {
//        matrixDouble4 = new MockDouble(2, 4, Double.class, 3.0);
//        matrixDouble5 = new MockDouble(3, 3, Double.class, -3.0);
//        matrixInteger4 = new MockInteger(2, 4, Integer.class, 3);
//        matrixInteger5 = new MockInteger(3, 3, Integer.class, -3);
//        
//        try {
//            calculator.substractMatrices(matrixDouble1, matrixDouble4, new ElementDouble());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(matrixDouble1, matrixDouble5, new ElementDouble());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(matrixDouble1, matrixDouble4, null);
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(matrixDouble1, null, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(null, matrixDouble2, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(null, null, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(matrixInteger1, matrixInteger4, new ElementInteger());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(matrixInteger1, matrixInteger5, new ElementInteger());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(matrixInteger1, matrixInteger4, null);
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(matrixInteger1, null, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(null, matrixInteger2, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.substractMatrices(null, null, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//    }
//    @Test
//    public void testMultiplyMatricesException() {
//        matrixDouble4 = new MockDouble(2, 4, Double.class, 3.0);
//        matrixInteger4 = new MockInteger(2, 4, Integer.class, 3);
//        
//        try {
//            calculator.multiplyMatrices(matrixDouble1, matrixDouble4, new ElementDouble());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(matrixDouble1, matrixDouble4, null);
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(matrixDouble1, null, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(null, matrixDouble2, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(null, null, new ElementDouble());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(matrixInteger1, matrixInteger4, new ElementInteger());
//            fail("Wrong dimensions exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(matrixInteger1, matrixInteger4, null);
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(matrixInteger1, null, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(null, matrixInteger2, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//        
//        try {
//            calculator.multiplyMatrices(null, null, new ElementInteger());
//            fail("Null exception was not catched!");
//        } catch (DimensionException e) {
//        }
//    }  
}
