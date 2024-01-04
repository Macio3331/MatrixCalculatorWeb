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
import pl.polsl.matrixcalculatorweb.model.DimensionException;
import pl.polsl.matrixcalculatorweb.model.ElementInteger;

/**
 * Class made for {@link pl.polsl.matrixcalculatorweb.model.ElementInteger}'s methods
 * testing.
 *
 * @author Maciej-Musiał
 * @version 2.1
 */
public class ElementIntegerTest {

    /**
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} object which methods
     * are tested.
     */
    private ElementInteger element;

    /**
     * Method that is being executed before each test. It initializes fields
     * created in this class.
     */
    @BeforeEach
    public void setUp() {
        element = new ElementInteger();
    }

    /**
     * Method used to provide parameters for add method of
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class. It creates
     * three {@link java.lang.Integer} objects inside of every argument - first
     * two are arguments of testing method and third represents the correct
     * result.
     *
     * @return stream of arguments which each consist three
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideIntsForAdd() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(2, -2, 0),
                Arguments.of(-2, 2, 0),
                Arguments.of(-2, -2, -4),
                Arguments.of(0, 0, 0),
                Arguments.of(0, -0, 0)
        );
    }

    /**
     * Test of add method of {@link pl.polsl.matrixcalculatorweb.model.ElementInteger}
     * class.
     *
     * @param value1 first {@link java.lang.Integer} object containing a value
     * @param value2 second {@link java.lang.Integer} object containing a value
     * @param result third {@link java.lang.Integer} object containing the
     * correct result of addition
     */
    @ParameterizedTest
    @MethodSource("provideIntsForAdd")
    void parameterizedTestAdd(Integer value1, Integer value2, Integer result) {
        try {
            assertEquals(element.add(value1, value2), result, 0.000001, "Adding did not work!");
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for subtract method of
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class. It creates
     * three {@link java.lang.Integer} objects inside of every argument - first
     * two are arguments of testing method and third represents the correct
     * result.
     *
     * @return stream of arguments which each consist three
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideIntsForSubtract() {
        return Stream.of(
                Arguments.of(2, 2, 0),
                Arguments.of(2, -2, 4),
                Arguments.of(-2, 2, -4),
                Arguments.of(-2, -2, 0),
                Arguments.of(0, 0, 0),
                Arguments.of(0, -0, 0)
        );
    }

    /**
     * Test of subtract method of
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class.
     *
     * @param value1 first {@link java.lang.Integer} object containing a value
     * @param value2 second {@link java.lang.Integer} object containing a value
     * @param result third {@link java.lang.Integer} object containing the
     * correct result of subtraction
     */
    @ParameterizedTest
    @MethodSource("provideIntsForSubtract")
    void parameterizedTestSubtract(Integer value1, Integer value2, Integer result) {
        try {
            assertEquals(element.subtract(value1, value2), result, 0.000001, "Subtracting did not work!");
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for multiply method of
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class. It creates
     * three {@link java.lang.Integer} objects inside of every argument - first
     * two are arguments of testing method and third represents the correct
     * result.
     *
     * @return stream of arguments which each consist three
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideIntsForMultiply() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(2, -2, -4),
                Arguments.of(-2, 2, -4),
                Arguments.of(-2, -2, 4),
                Arguments.of(0, 0, 0),
                Arguments.of(0, -0, 0),
                Arguments.of(1, 0, 0),
                Arguments.of(-1, 0, 0)
        );
    }

    /**
     * Test of multiply method of
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class.
     *
     * @param value1 first {@link java.lang.Integer} object containing a value
     * @param value2 second {@link java.lang.Integer} object containing a value
     * @param result third {@link java.lang.Integer} object containing the
     * correct result of multiplcation
     */
    @ParameterizedTest
    @MethodSource("provideIntsForMultiply")
    void parameterizedTestMultiply(Integer value1, Integer value2, Integer result) {
        try {
            assertEquals(element.multiply(value1, value2), result, 0.000001, "Multiplying did not work!");
        } catch (DimensionException e) {
            fail("Catching exception when it should not be catched!");
        }
    }

    /**
     * Method used to provide parameters for add, subtract and multiply methods
     * of {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class. It creates
     * two {@link java.lang.Integer} objects inside of every argument which are
     * arguments of testing methods. It produces incorrect data for those
     * methods.
     *
     * @return stream of arguments which each consist two
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideIntsForAddSubtractMultiplyException() {
        return Stream.of(
                Arguments.of(null, 2),
                Arguments.of(2, null),
                Arguments.of(null, null)
        );
    }

    /**
     * Test of add method of {@link pl.polsl.matrixcalculatorweb.model.ElementInteger}
     * class. It tests a situation of invalid data passed when exception should
     * be thrown.
     *
     * @param value1 first {@link java.lang.Integer} object containing a value
     * @param value2 second {@link java.lang.Integer} object containing a value
     */
    @ParameterizedTest
    @MethodSource("provideIntsForAddSubtractMultiplyException")
    void parameterizedTestAddException(Integer value1, Integer value2) {
        try {
            element.add(value1, value2);
            fail("An exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Test of subtract method of
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param value1 first {@link java.lang.Integer} object containing a value
     * @param value2 second {@link java.lang.Integer} object containing a value
     */
    @ParameterizedTest
    @MethodSource("provideIntsForAddSubtractMultiplyException")
    void parameterizedTestSubtractException(Integer value1, Integer value2) {
        try {
            element.subtract(value1, value2);
            fail("An exception was not catched!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Test of multiply method of
     * {@link pl.polsl.matrixcalculatorweb.model.ElementInteger} class. It tests a
     * situation of invalid data passed when exception should be thrown.
     *
     * @param value1 first {@link java.lang.Integer} object containing a value
     * @param value2 second {@link java.lang.Integer} object containing a value
     */
    @ParameterizedTest
    @MethodSource("provideIntsForAddSubtractMultiplyException")
    void parameterizedTestMultiplyException(Integer value1, Integer value2) {
        try {
            element.multiply(value1, value2);
            fail("An exception was not catched!");
        } catch (DimensionException e) {
        }
    }

//    @Test
//    public void testAdd() {
//        try {
//            assertEquals(element.add(2, 2), 4, 0.000001, "Adding two positive values did not work!");
//            assertEquals(element.add(2, -2), 0, 0.000001, "Adding first positive and second negative values did not work!");
//            assertEquals(element.add(-2, 2), 0, 0.000001, "Adding first negative and second positive values did not work!");
//            assertEquals(element.add(-2, -2), -4, 0.000001, "Adding two negative values did not work!");
//            assertEquals(element.add(0, 0), 0, 0.000001, "Adding two zero values did not work!");
//            assertEquals(element.add(0, -0), 0, 0.000001, "Adding two zero (one negative) values did not work!");
//        } catch(DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }  
//    }
//    @Test
//    public void testSubstract() {
//        try {
//            assertEquals(element.subtract(2, 2), 0, 0.000001, "Substracting two positive values did not work!");
//            assertEquals(element.subtract(2, -2), 4, 0.000001, "Substracting first positive and second negative values did not work!");
//            assertEquals(element.subtract(-2, 2), -4, 0.000001, "Substracting first negative and second positive values did not work!");
//            assertEquals(element.subtract(-2, -2), 0, 0.000001, "Substracting two negative values did not work!");
//            assertEquals(element.subtract(0, 0), 0, 0.000001, "Substracting two zero values did not work!");
//            assertEquals(element.subtract(0, -0), 0, 0.000001, "Substracting two zero (one negative) values did not work!");
//        } catch(DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }  
//    }
//    @Test
//    public void testMultiply() {
//        try {
//            assertEquals(element.multiply(2, 2), 4, 0.000001, "Multiplying two positive values did not work!");
//            assertEquals(element.multiply(2, -2), -4, 0.000001, "Multiplying first positive and second negative values did not work!");
//            assertEquals(element.multiply(-2, 2), -4, 0.000001, "Multiplying first negative and second positive values did not work!");
//            assertEquals(element.multiply(-2, -2), 4, 0.000001, "Multiplying two negative values did not work!");
//            assertEquals(element.multiply(0, 0), 0, 0.000001, "Multiplying two zero values did not work!");
//            assertEquals(element.multiply(0, -0), 0, 0.000001, "Multiplying two zero (one negative) values did not work!");
//            assertEquals(element.multiply(1, 0), 0, 0.000001, "Multiplying positive and zero values did not work!");
//            assertEquals(element.multiply(-1, 0), 0, 0.000001, "Multiplying negative and zero values did not work!");
//        } catch(DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }  
//    }
//    @Test
//    public void testAddException() {
//        try {
//            element.add(0, 0);
//        }
//        catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//        
//        try {
//            element.add(null, 0);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//        
//        try {
//            element.add(0, null);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//        
//        try {
//            element.add(null, null);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//    }  
//    @Test
//    public void testSubtractException() {
//        try {
//            element.subtract(0, 0);
//        }
//        catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//        
//        try {
//            element.subtract(null, 0);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//        
//        try {
//            element.subtract(0, null);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//        
//        try {
//            element.subtract(null, null);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//    }
//    @Test
//    public void testMultiplyException() {
//        try {
//            element.multiply(0, 0);
//        }
//        catch (DimensionException e) {
//            fail("Catching exception when it should not be catched!");
//        }
//        
//        try {
//            element.multiply(null, 0);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//        
//        try {
//            element.multiply(0, null);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//        
//        try {
//            element.multiply(null, null);
//            fail("Null exception was not catched!");
//        }
//        catch (DimensionException e) {
//        }
//    }
}
