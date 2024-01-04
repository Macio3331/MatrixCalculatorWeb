// definition of the package in which class is placed
package pl.polsl.unittests;

// packages containing class definitions
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import pl.polsl.matrixcalculatorweb.model.DimensionException;
import pl.polsl.matrixcalculatorweb.model.Matrix;

/**
 * Class made for {@link pl.polsl.matrixcalculatorweb.model.Matrix}'s methods testing.
 *
 * @author Maciej-Musiał
 * @version 2.1
 */
public class MatrixTest {

//    /**
//     * Method used to provide parameters for toString method of
//     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class. It creates one
//     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} and one
//     * {@link java.lang.String} object inside of every argument - matrix object
//     * on which method is used and the correct result.
//     *
//     * @return stream of arguments which each consist one
//     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} and one
//     * {@link java.lang.String} object
//     */
//    private static Stream<Arguments> provideMatrixDoubleParametersForToString() {
//        return Stream.of(
//                Arguments.of(new Matrix<>(2, 3, Double.class, 1.0), "[1, 1] = 1.0\n[1, 2] = 1.0\n[1, 3] = 1.0\n[2, 1] = 1.0\n[2, 2] = 1.0\n[2, 3] = 1.0"),
//                Arguments.of(new Matrix<>(3, 2, Double.class, -1.0), "[1, 1] = -1.0\n[1, 2] = -1.0\n[2, 1] = -1.0\n[2, 2] = -1.0\n[3, 1] = -1.0\n[3, 2] = -1.0"),
//                Arguments.of(new Matrix<>(1, 1, Double.class, 0.0), "[1, 1] = 0.0")
//        );
//    }

//    /**
//     * Test of toString method of {@link pl.polsl.matrixcalculatorweb.model.Matrix}
//     * class.
//     *
//     * @param matrix {@link pl.polsl.matrixcalculatorweb.model.Matrix} object on which
//     * method is executed
//     * @param correctResult {@link java.lang.String} object containing the
//     * correct result
//     */
//    @ParameterizedTest
//    @MethodSource("provideMatrixDoubleParametersForToString")
//    void parameterizedTestDoubleToString(Matrix<Double> matrix, String correctResult) {
//        assertEquals(matrix.toString(), correctResult, "String did not work!");
//    }

//    /**
//     * Method used to provide parameters for toString method of
//     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class. It creates one
//     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} and one
//     * {@link java.lang.String} object inside of every argument - matrix object
//     * on which method is used and the correct result.
//     *
//     * @return stream of arguments which each consist one
//     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} and one
//     * {@link java.lang.String} object
//     */
//    private static Stream<Arguments> provideMatrixIntParametersForToString() {
//        return Stream.of(
//                Arguments.of(new Matrix<>(2, 3, Integer.class, 1), "[1, 1] = 1\n[1, 2] = 1\n[1, 3] = 1\n[2, 1] = 1\n[2, 2] = 1\n[2, 3] = 1"),
//                Arguments.of(new Matrix<>(3, 2, Integer.class, -1), "[1, 1] = -1\n[1, 2] = -1\n[2, 1] = -1\n[2, 2] = -1\n[3, 1] = -1\n[3, 2] = -1"),
//                Arguments.of(new Matrix<>(1, 1, Integer.class, 0), "[1, 1] = 0")
//        );
//    }

//    /**
//     * Test of toString method of {@link pl.polsl.matrixcalculatorweb.model.Matrix}
//     * class.
//     *
//     * @param matrix {@link pl.polsl.matrixcalculatorweb.model.Matrix} object on which
//     * method is executed
//     * @param correctResult {@link java.lang.String} object containing the
//     * correct result
//     */
//    @ParameterizedTest
//    @MethodSource("provideMatrixIntParametersForToString")
//    void parameterizedTestIntToString(Matrix<Integer> matrix, String correctResult) {
//        assertEquals(matrix.toString(), correctResult, "String did not work!");
//    }

    /**
     * Method used to provide parameters for getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class. It creates one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and one
     * {@link java.lang.Double} object inside of every argument - matrix object
     * on which method is used, two arguments of testing method and the correct
     * result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and one
     * {@link java.lang.Double} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForGet() {
        return Stream.of(
                Arguments.of(new Matrix<>(2, 3, Double.class, 1.0), 0, 0, 1.0),
                Arguments.of(new Matrix<>(3, 2, Double.class, -1.0), 0, 0, -1.0),
                Arguments.of(new Matrix<>(5, 5, Double.class, 0.0), 0, 0, 0.0)
        );
    }

    /**
     * Test of getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class.
     *
     * @param matrix {@link pl.polsl.matrixcalculatorweb.model.Matrix} object on which
     * method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param correctResult {@link java.lang.Double} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForGet")
    void parameterizedTestDoubleGetMatrixValue(Matrix<Double> matrix, int row, int column, Double correctResult) {
        try {
            assertEquals(matrix.getMatrixValue(row, column), correctResult, 0.000001, "Getting did not work!");
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class. It creates one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and one
     * {@link java.lang.Integer} object inside of every argument - matrix object
     * on which method is used, two arguments of testing method and the correct
     * result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and one
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixIntParametersForGet() {
        return Stream.of(
                Arguments.of(new Matrix<>(2, 3, Integer.class, 1), 0, 0, 1),
                Arguments.of(new Matrix<>(3, 2, Integer.class, -1), 0, 0, -1),
                Arguments.of(new Matrix<>(5, 5, Integer.class, 0), 0, 0, 0)
        );
    }

    /**
     * Test of getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class.
     *
     * @param matrix {@link pl.polsl.matrixcalculatorweb.model.Matrix} object on which
     * method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForGet")
    void parameterizedTestIntGetMatrixValue(Matrix<Integer> matrix, int row, int column, Integer correctResult) {
        try {
            assertEquals(matrix.getMatrixValue(row, column), correctResult, 0.000001, "Getting did not work!");
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for changeMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class. It creates one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and two
     * {@link java.lang.Double} object inside of every argument - matrix object
     * on which method is used, three arguments of testing method and the
     * correct result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and two
     * {@link java.lang.Double} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForChange() {
        return Stream.of(
                Arguments.of(new Matrix<>(2, 3, Double.class, 1.0), 0, 0, 2.0, 2.0),
                Arguments.of(new Matrix<>(3, 2, Double.class, -1.0), 0, 0, -2.0, -2.0),
                Arguments.of(new Matrix<>(5, 5, Double.class, 0.0), 0, 0, 0.0, 0.0)
        );
    }

    /**
     * Test of changeMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class.
     *
     * @param matrix {@link pl.polsl.matrixcalculatorweb.model.Matrix} object on which
     * method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param value {@link java.lang.Double} objcet containing a value assigned
     * to the element of passed position
     * @param correctResult {@link java.lang.Double} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForChange")
    void parameterizedTestDoubleChangeMatrixValue(Matrix<Double> matrix, int row, int column, Double value, Double correctResult) {
        try {
            matrix.changeMatrixValue(row, column, value);
            assertEquals(matrix.getMatrixValue(row, column), correctResult, 0.000001, "Changing did not work!");
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for changeMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class. It creates one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and two
     * {@link java.lang.Integer} object inside of every argument - matrix object
     * on which method is used, three arguments of testing method and the
     * correct result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix}, two integers and two
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixIntParametersForChange() {
        return Stream.of(
                Arguments.of(new Matrix<Integer>(2, 3, Integer.class, 1), 0, 0, 2, 2),
                Arguments.of(new Matrix<Integer>(3, 2, Integer.class, -1), 0, 0, -2, -2),
                Arguments.of(new Matrix<Integer>(5, 5, Integer.class, 0), 0, 0, 0, 0)
        );
    }

    /**
     * Test of changeMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class.
     *
     * @param matrix {@link pl.polsl.matrixcalculatorweb.model.Matrix} object on which
     * method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param value {@link java.lang.Integer} objcet containing a value assigned
     * to the element of passed position
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForChange")
    void parameterizedTestIntChangeMatrixValue(Matrix<Integer> matrix, int row, int column, Integer value, Integer correctResult) {
        try {
            matrix.changeMatrixValue(row, column, value);
            assertEquals(matrix.getMatrixValue(row, column), correctResult, 0.000001, "Changing did not work!");
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class. It creates four
     * integer values inside of every argument - two parameters for creating a
     * matrix and two arguments of testing method. It produces incorrect data
     * for this method.
     *
     * @return stream of arguments which each consist four integer values
     */
    private static Stream<Arguments> provideMatrixParametersForGetException() {
        return Stream.of(
                Arguments.of(2, 3, -1, 0),
                Arguments.of(2, 3, 0, -1),
                Arguments.of(2, 3, -1, -1),
                Arguments.of(2, 3, 2, 2),
                Arguments.of(2, 3, 1, 3),
                Arguments.of(2, 3, 2, 3)
        );
    }

    /**
     * Test of getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class with {link
     * java.lang.Double} objects. It tests a situation of invalid data passed
     * when exception should be thrown.
     *
     * @param height integer value representing the height of matrix
     * @param width integer value representing the width of matrix
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     */
    @ParameterizedTest
    @MethodSource("provideMatrixParametersForGetException")
    void parameterizedTestDoubleGetMatrixValueException(int height, int width, int row, int column) {
        try {
            new Matrix<>(height, width, Double.class).getMatrixValue(row, column);
            fail("An exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Test of getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class with {link
     * java.lang.Integer} objects. It tests a situation of invalid data passed
     * when exception should be thrown.
     *
     * @param height integer value representing the height of matrix
     * @param width integer value representing the width of matrix
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     */
    @ParameterizedTest
    @MethodSource("provideMatrixParametersForGetException")
    void parameterizedTestIntGetMatrixValueException(int height, int width, int row, int column) {
        try {
            new Matrix<>(height, width, Integer.class).getMatrixValue(row, column);
            fail("An exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for changeMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class with {link
     * java.lang.Double} objects. It creates four integer values and one
     * {@link java.lang.Double} object inside of every argument - two parameters
     * for creating a matrix and three arguments of testing method. It produces
     * incorrect data for this method.
     *
     * @return stream of arguments which each consist four integer values and
     * one {@link java.lang.Double} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForChangeException() {
        return Stream.of(
                Arguments.of(2, 3, -1, 0, 1.0),
                Arguments.of(2, 3, 0, -1, 1.0),
                Arguments.of(2, 3, -1, -1, 1.0),
                Arguments.of(2, 3, 2, 2, 1.0),
                Arguments.of(2, 3, 1, 3, 1.0),
                Arguments.of(2, 3, 2, 3, 1.0),
                Arguments.of(2, 3, 0, 0, null)
        );
    }

    /**
     * Test of getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class with {link
     * java.lang.Double} objects. It tests a situation of invalid data passed
     * when exception should be thrown.
     *
     * @param height integer value representing the height of matrix
     * @param width integer value representing the width of matrix
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param value {@link java.lang.Double} object conatining a value
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForChangeException")
    void parameterizedTestDoubleChangeMatrixValueException(int height, int width, int row, int column, Double value) {
        try {
            new Matrix<>(height, width, Double.class).changeMatrixValue(row, column, value);
            fail("An exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for changeMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class with {link
     * java.lang.Integer} objects. It creates four integer values and one
     * {@link java.lang.Integer} object inside of every argument - two
     * parameters for creating a matrix and three arguments of testing method.
     * It produces incorrect data for this method.
     *
     * @return stream of arguments which each consist four integer values and
     * one {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixIntParametersForChangeException() {
        return Stream.of(
                Arguments.of(2, 3, -1, 0, 1),
                Arguments.of(2, 3, 0, -1, 1),
                Arguments.of(2, 3, -1, -1, 1),
                Arguments.of(2, 3, 2, 2, 1),
                Arguments.of(2, 3, 1, 3, 1),
                Arguments.of(2, 3, 2, 3, 1),
                Arguments.of(2, 3, 0, 0, null)
        );
    }

    /**
     * Test of getMatrixValue method of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class with {link
     * java.lang.Integer} objects. It tests a situation of invalid data passed
     * when exception should be thrown.
     *
     * @param height integer value representing the height of matrix
     * @param width integer value representing the width of matrix
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param value {@link java.lang.Integer} object conatining a value
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntParametersForChangeException")
    void parameterizedTestIntChangeMatrixValueException(int height, int width, int row, int column, Integer value) {
        try {
            new Matrix<>(height, width, Integer.class).changeMatrixValue(row, column, value);
            fail("An exception was not catched!");
        } catch (DimensionException e) {
        }
    }

//    Matrix<Double> matrixDouble1;
//    Matrix<Double> matrixDouble2;
//    Matrix<Double> matrixDouble3;
//    Matrix<Integer> matrixInteger1;
//    Matrix<Integer> matrixInteger2;
//    Matrix<Integer> matrixInteger3;
//    @BeforeEach
//    public void setUp() {
//        matrixDouble1 = new Matrix<>(2, 3, Double.class, 1.0);
//        matrixDouble2 = new Matrix<>(3, 2, Double.class, -1.0);
//        matrixDouble3 = new Matrix<>(5, 5, Double.class);
//        matrixInteger1 = new Matrix<>(2, 3, Integer.class, 1);
//        matrixInteger2 = new Matrix<>(3, 2, Integer.class, -1);
//        matrixInteger3 = new Matrix<>(5, 5, Integer.class);
//    }
//    
//    @Test
//    public void testGetMatrixValue() {
//        try{
//            assertEquals(matrixDouble1.getMatrixValue(0, 0), 1.0, 0.000001, "Matrix values did not match!");
//            assertEquals(matrixDouble2.getMatrixValue(0, 0), -1.0, 0.000001, "Matrix values did not match!");
//            assertEquals(matrixDouble3.getMatrixValue(0, 0), 0.0, 0.000001, "Matrix values did not match!");
//            assertEquals(matrixInteger1.getMatrixValue(0, 0), 1, 0.000001, "Matrix values did not match!");
//            assertEquals(matrixInteger2.getMatrixValue(0, 0), -1, 0.000001, "Matrix values did not match!");
//            assertEquals(matrixInteger3.getMatrixValue(0, 0), 0, 0.000001, "Matrix values did not match!");
//        } catch(DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//    }
//    @Test
//    public void testChangeMatrixValue() {
//        try{
//            matrixDouble1.changeMatrixValue(0, 0, 2.0);
//            assertEquals(matrixDouble1.getMatrixValue(0, 0), 2.0, 0.000001, "Matrix values did not match!");
//            matrixDouble2.changeMatrixValue(0, 0, -2.0);
//            assertEquals(matrixDouble2.getMatrixValue(0, 0), -2.0, 0.000001, "Matrix values did not match!");
//            matrixDouble3.changeMatrixValue(0, 0, 0.0);
//            assertEquals(matrixDouble3.getMatrixValue(0, 0), 0, 0.000001, "Matrix values did not match!");
//            matrixInteger1.changeMatrixValue(0, 0, 2);
//            assertEquals(matrixInteger1.getMatrixValue(0, 0), 2, 0.000001, "Matrix values did not match!");
//            matrixInteger2.changeMatrixValue(0, 0, -2);
//            assertEquals(matrixInteger2.getMatrixValue(0, 0), -2, 0.000001, "Matrix values did not match!");
//            matrixInteger3.changeMatrixValue(0, 0, 0);
//            assertEquals(matrixInteger3.getMatrixValue(0, 0), 0, 0.000001, "Matrix values did not match!");
//        } catch(DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//    }
//    @Test
//    public void testGetMatrixValueException() {
//        try {
//            matrixDouble1.getMatrixValue(1, 2);
//        }
//        catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//        
//        try{
//            matrixDouble1.getMatrixValue(-1, 0);
//            fail("Negative number in column exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.getMatrixValue(0, -1);
//            fail("Negative number in row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.getMatrixValue(-1, -1);
//            fail("Negative number in column and row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.getMatrixValue(2, 2);
//            fail("Number greater than number of columns exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.getMatrixValue(1, 3);
//            fail("Number greater than number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.getMatrixValue(2, 3);
//            fail("Number greater than number of columns and number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try {
//            matrixInteger1.getMatrixValue(1, 2);
//        }
//        catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//        
//        try{
//            matrixInteger1.getMatrixValue(-1, 0);
//            fail("Negative number in column exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.getMatrixValue(0, -1);
//            fail("Negative number in row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.getMatrixValue(-1, -1);
//            fail("Negative number in column and row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.getMatrixValue(2, 2);
//            fail("Number greater than number of columns exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.getMatrixValue(1, 3);
//            fail("Number greater than number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.getMatrixValue(2, 3);
//            fail("Number greater than number of columns and number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//    }
//    @Test
//    public void testChangeMatrixValueException() {
//        try {
//            matrixDouble1.changeMatrixValue(1, 2, 2.0);
//        }
//        catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//        
//        try{
//            matrixDouble1.changeMatrixValue(-1, 0, 2.0);
//            fail("Negative number in column exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.changeMatrixValue(0, -1, 2.0);
//            fail("Negative number in row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.changeMatrixValue(-1, -1, 2.0);
//            fail("Negative number in column and row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.changeMatrixValue(2, 2, 2.0);
//            fail("Number greater than number of columns exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.changeMatrixValue(1, 3, 2.0);
//            fail("Number greater than number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.changeMatrixValue(2, 3, 2.0);
//            fail("Number greater than number of columns and number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixDouble1.changeMatrixValue(1, 2, null);
//            fail("Null exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try {
//            matrixInteger1.changeMatrixValue(1, 2, 2);
//        }
//        catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//        
//        try{
//            matrixInteger1.changeMatrixValue(-1, 0, 2);
//            fail("Negative number in column exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.changeMatrixValue(0, -1, 2);
//            fail("Negative number in row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.changeMatrixValue(-1, -1, 2);
//            fail("Negative number in column and row exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.changeMatrixValue(2, 2, 2);
//            fail("Number greater than number of columns exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.changeMatrixValue(1, 3, 2);
//            fail("Number greater than number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.changeMatrixValue(2, 3, 2);
//            fail("Number greater than number of columns and number of rows exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//        
//        try{
//            matrixInteger1.changeMatrixValue(1, 2, null);
//            fail("Null exception was not catched!");
//        } catch(DimensionException e) {   
//        }
//    }
}
