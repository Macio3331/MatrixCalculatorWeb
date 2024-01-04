// definition of the package in which class is placed
package pl.polsl.unittests;

// packages containing class definitions
import pl.polsl.matrixcalculatorweb.model.IMatrix;
import pl.polsl.matrixcalculatorweb.model.DimensionException;

/**
 * A class in the 'model' package. The class implements
 * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface with
 * {@link java.lang.Double} type and is used for testing purposes. It imitates
 * {@link pl.polsl.matrixcalculatorweb.model.Matrix} class.
 *
 * @author Maciej-Musiał
 * @version 1.2
 */
public class MockDouble implements IMatrix<Double> {

    /**
     * Field storing the type of {link java.lang.Double} class.
     */
    private Class<Double> classType;

    /**
     * Integer value. Represents a height of matrix.
     */
    private int height;

    /**
     * Integer value. Represents a width of matrix.
     */
    private int width;

    /**
     * Table 2D of {@link java.lang.Double} objects. Represents values of
     * matrix.
     */
    private Double[][] matrixValues;

    /**
     * Non-parameter MockDouble constructor.
     */
    public MockDouble() {
        height = 0;
        width = 0;
        matrixValues = new Double[height][width];
    }

    /**
     * MockDouble constructor. Initiates
     * {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object using height and
     * width parameters along with type class of {@link java.lang.Double}.
     *
     * @param a integer value - represents height
     * @param b integer value - represents width
     * @param type {@link java.lang.Double} type of the elements stored inside
     * {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object
     */
    public MockDouble(int a, int b, Class<Double> type) {
        height = a;
        width = b;
        matrixValues = new Double[height][width];
        classType = type;
        initializeMatrixValues(0.0);
    }

    /**
     * MockDouble constructor. Initiates
     * {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object using height and
     * width, class type and value parameters.
     *
     * @param a integer value - represents height
     * @param b integer value - represents width
     * @param type {@link java.lang.Double} type of the elements stored inside
     * {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object
     * @param value initializing value of every matrix element
     */
    public MockDouble(int a, int b, Class<Double> type, Double value) {
        height = a;
        width = b;
        matrixValues = new Double[height][width];
        classType = type;
        initializeMatrixValues(value);
    }

    /**
     * Private method used by parameter constructors to initialize values of
     * {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object.
     *
     * @param value value of {@link java.lang.Double} type used for
     * initialization
     */
    private void initializeMatrixValues(Double value) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrixValues[i][j] = value;
            }
        }
    }

    /**
     * Returns height of {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object.
     *
     * @return height of {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Returns width of {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object.
     *
     * @return width of {@link pl.polsl.matrixcalculatorweb.model.MockDouble} object
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns class type of {@link java.lang.Double} object.
     *
     * @return class type of {@link java.lang.Double} object
     */
    @Override
    public Class<Double> getClassType() {
        return classType;
    }

    /**
     * Returns table 2D of {@link java.lang.Double} objects.
     *
     * @return table 2D of {@link java.lang.Double} objects.
     */
    public Double[][] getMatrixValues() {
        return matrixValues;
    }

    /**
     * Returns {@link java.lang.Double} object stored in passed position.
     *
     * @param column integer value representing a column
     * @param row integer value representing a row
     * @return {@link java.lang.Double} object stored in passed position
     * @throws DimensionException when refernces are null values or row and
     * column values are invalid
     */
    @Override
    public Double getMatrixValue(int row, int column) throws DimensionException {
        if (row < 0 || column < 0) {
            throw new DimensionException("Numer kolumny i numer wiersza muszą być co najmniej równe 0!");
        } else if (row > height - 1 || column > width - 1) {
            throw new DimensionException("Wskazany numer kolumny lub wiersza wychodzi poza zakres wymiarów macierzy!");
        }
        return matrixValues[row][column];
    }

    /**
     * Changes matrix's element to value passed by parameter on specified
     * position.
     *
     * @param column integer value representing a column
     * @param row integer value representing a row
     * @param value {@link java.lang.Double} object representing the value of
     * that type
     * @throws DimensionException when refernces are null values or row and
     * column values are invalid
     */
    @Override
    public void changeMatrixValue(int row, int column, Double value) throws DimensionException {
        if (value == null) {
            throw new DimensionException("Niezainicjalizowana wartość parametru!");
        } else if (row < 0 || column < 0) {
            throw new DimensionException("Numer kolumny i numer wiersza muszą być co najmniej równe 0!");
        } else if (row > height - 1 || column > width - 1) {
            throw new DimensionException("Wskazany numer kolumny lub wiersza wychodzi poza zakres wymiarów macierzy!");
        }
        matrixValues[row][column] = value;
    }
}
