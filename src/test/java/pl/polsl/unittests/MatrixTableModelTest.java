// definition of the package in which class is placed
package pl.polsl.unittests;

// packages containing class definitions
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.polsl.matrixcalculatorweb.model.DimensionException;
import pl.polsl.matrixcalculatorweb.model.MatrixTableModel;

/**
 * Class made for {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}'s
 * methods testing.
 *
 * @author Maciej-Musiał
 * @version 2.1
 */
public class MatrixTableModelTest {

    /**
     * Method used to provide parameters for getValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}, two integers
     * and one {@link java.lang.Double} object inside of every argument - object
     * on which method is used, two arguments of testing method and the correct
     * result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object, two
     * integers and one {@link java.lang.Double} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForGet() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Double.class), 0, 0, 0.0)
        );
    }

    /**
     * Test of getValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param correctResult {@link java.lang.Double} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForGet")
    void parameterizedTestDoubleGetValueAt(MatrixTableModel<Double> model, int row, int column, Double correctResult) {
        assertEquals((Double) model.getValueAt(row, column), correctResult, 0.000001, "Getting did not work!");
    }

    /**
     * Method used to provide parameters for getValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}, two integers
     * and one {@link java.lang.Integer} object inside of every argument -
     * object on which method is used, two arguments of testing method and the
     * correct result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object, two
     * integers and one {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixIntegerParametersForGet() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Integer.class), 0, 0, 0)
        );
    }

    /**
     * Test of getValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForGet")
    void parameterizedTestIntegerGetValueAt(MatrixTableModel<Integer> model, int row, int column, Integer correctResult) {
        assertEquals((Integer) model.getValueAt(row, column), correctResult, 0.000001, "Getting did not work!");
    }

    /**
     * Method used to provide parameters for setValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}, two integers
     * and one {@link java.lang.Double} object inside of every argument - object
     * on which method is used, three arguments of testing method and the
     * correct result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object, two
     * integers and two {@link java.lang.Double} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForSet() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Double.class), 0, 0, 1.0, 1.0)
        );
    }

    /**
     * Test of setValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param value {@link java.lang.Double} object containing new value
     * @param correctResult {@link java.lang.Double} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForSet")
    void parameterizedTestDoubleSetValueAt(MatrixTableModel<Double> model, int row, int column, Double value, Double correctResult) {
        model.setValueAt(value, row, column);
        assertEquals((Double) model.getValueAt(row, column), correctResult, 0.000001, "Setting did not work!");
    }

    /**
     * Method used to provide parameters for setValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}, two integers
     * and one {@link java.lang.Integer} object inside of every argument -
     * object on which method is used, three arguments of testing method and the
     * correct result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object, two
     * integers and two {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixIntegerParametersForSet() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Integer.class), 0, 0, 1, 1)
        );
    }

    /**
     * Test of setValueAt method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param row integer value representing row's position
     * @param column integer value representing column's position
     * @param value {@link java.lang.Integer} object containing new value
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForSet")
    void parameterizedTestIntegerSetValueAt(MatrixTableModel<Integer> model, int row, int column, Integer value, Integer correctResult) {
        model.setValueAt(value, row, column);
        assertEquals((Integer) model.getValueAt(row, column), correctResult, 0.000001, "Setting did not work!");
    }

    /**
     * Method used to provide parameters for addColumn and addRow methods of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and the correct
     * result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and one
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForAddColumnRow() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Double.class), 2)
        );
    }

    /**
     * Test of addColumn method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForAddColumnRow")
    void parameterizedTestDoubleAddColumn(MatrixTableModel<Double> model, Integer correctResult) {
        model.addColumn();
        assertEquals(model.getColumnCount(), correctResult, "Adding column did not work!");
    }

    /**
     * Test of addRow method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForAddColumnRow")
    void parameterizedTestDoubleAddRow(MatrixTableModel<Double> model, Integer correctResult) {
        model.addRow();
        assertEquals(model.getRowCount(), correctResult, "Adding row did not work!");
    }

    /**
     * Method used to provide parameters for addColumn and addRow methods of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and the correct
     * result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and one
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixIntegerParametersForAddColumnRow() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Integer.class), 2)
        );
    }

    /**
     * Test of addColumn method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForAddColumnRow")
    void parameterizedTestIntegerAddColumn(MatrixTableModel<Integer> model, Integer correctResult) {
        model.addColumn();
        assertEquals(model.getColumnCount(), correctResult, "Adding column did not work!");
    }

    /**
     * Test of addRow method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForAddColumnRow")
    void parameterizedTestIntegerAddRow(MatrixTableModel<Integer> model, Integer correctResult) {
        model.addRow();
        assertEquals(model.getRowCount(), correctResult, "Adding row did not work!");
    }

    /**
     * Method used to provide parameters for removeColumn and removeRow methods
     * of {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It
     * creates one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and the
     * correct result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and one
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForRemoveColumnRow() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(2, 2, Double.class), 1)
        );
    }

    /**
     * Test of removeColumn method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForRemoveColumnRow")
    void parameterizedTestDoubleRemoveColumn(MatrixTableModel<Double> model, Integer correctResult) {
        try {
            model.removeColumn();
            assertEquals(model.getColumnCount(), correctResult, "Removing column did not work!");
        } catch (DimensionException e) {
            fail("Exception catched when it should not been!");
        }
    }

    /**
     * Test of removeRow method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForRemoveColumnRow")
    void parameterizedTestDoubleRemoveRow(MatrixTableModel<Double> model, Integer correctResult) {
        try {
            model.removeRow();
            assertEquals(model.getRowCount(), correctResult, "Removing row did not work!");
        } catch (DimensionException e) {
            fail("Exception catched when it should not been!");
        }
    }

    /**
     * Method used to provide parameters for removeColumn and removeRow methods
     * of {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It
     * creates one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and the
     * correct result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and one
     * {@link java.lang.Integer} object
     */
    private static Stream<Arguments> provideMatrixIntegerParametersForRemoveColumnRow() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(2, 2, Integer.class), 1)
        );
    }

    /**
     * Test of removeColumn method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForRemoveColumnRow")
    void parameterizedTestIntegerRemoveColumn(MatrixTableModel<Integer> model, Integer correctResult) {
        try {
            model.removeColumn();
            assertEquals(model.getColumnCount(), correctResult, "Removing column did not work!");
        } catch (DimensionException e) {
            fail("Exception catched when it should not been!");
        }
    }

    /**
     * Test of removeRow method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     * @param correctResult {@link java.lang.Integer} object containing the
     * correct result
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForRemoveColumnRow")
    void parameterizedTestIntegerRemoveRow(MatrixTableModel<Integer> model, Integer correctResult) {
        try {
            model.removeRow();
            assertEquals(model.getRowCount(), correctResult, "Removing row did not work!");
        } catch (DimensionException e) {
            fail("Exception catched when it should not been!");
        }
    }

    /**
     * Method used to provide parameters for removeColumn and removeRow methods
     * of {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It
     * creates one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForRemoveColumnRowException() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(0, 0, Double.class))
        );
    }

    /**
     * Test of exception inside of removeColumn method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForRemoveColumnRowException")
    void parameterizedTestDoubleRemoveColumnException(MatrixTableModel<Double> model) {
        try {
            model.removeColumn();
            fail("Exception was not catched when it should be!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Test of exception inside of removeRow method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForRemoveColumnRowException")
    void parameterizedTestDoubleRemoveRowException(MatrixTableModel<Double> model) {
        try {
            model.removeRow();
            fail("Exception was not catched when it should be!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for removeColumn and removeRow methods
     * of {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It
     * creates one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}
     */
    private static Stream<Arguments> provideMatrixIntegerParametersForRemoveColumnRowException() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(0, 0, Integer.class))
        );
    }

    /**
     * Test of exception inside of removeColumn method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForRemoveColumnRowException")
    void parameterizedTestIntegerRemoveColumnException(MatrixTableModel<Integer> model) {
        try {
            model.removeColumn();
            fail("Exception was not catched when it should be!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Test of exception inside of removeRow method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForRemoveColumnRowException")
    void parameterizedTestIntegerRemoveRowException(MatrixTableModel<Integer> model) {
        try {
            model.removeRow();
            fail("Exception was not catched when it should be!");
        } catch (DimensionException e) {
        }
    }

    /**
     * Method used to provide parameters for getColumnClass method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and the correct
     * result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}
     */
    private static Stream<Arguments> provideMatrixDoubleParametersForGetColumnClass() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Double.class))
        );
    }

    /**
     * Test of getColumnClass method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     */
    @ParameterizedTest
    @MethodSource("provideMatrixDoubleParametersForGetColumnClass")
    void parameterizedTestDoubleGetClolumnClass(MatrixTableModel<Double> model) {
        assertEquals(model.getColumnClass(0), Double.class, "Getting column class did not work!");
    }

    /**
     * Method used to provide parameters for getColumnClass method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class. It creates
     * one {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} and the correct
     * result.
     *
     * @return stream of arguments which each consist one
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel}
     */
    private static Stream<Arguments> provideMatrixIntegerParametersForGetColumnClass() {
        return Stream.of(
                Arguments.of(new MatrixTableModel<>(Integer.class))
        );
    }

    /**
     * Test of getColumnClass method of
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} class.
     *
     * @param model {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     * on which method is executed
     */
    @ParameterizedTest
    @MethodSource("provideMatrixIntegerParametersForGetColumnClass")
    void parameterizedTestIntegerGetColumnClass(MatrixTableModel<Integer> model) {
        assertEquals(model.getColumnClass(0), Integer.class, "Getting column class did not work!");
    }
}
