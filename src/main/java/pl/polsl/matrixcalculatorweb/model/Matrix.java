// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

// packages containing class definitions 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * A class in the 'model' package. The class implements
 * {@link pl.polsl.matrixcalculatorweb.model.IMatrix} interface and Serializable
 * interface and represents a matrix of any number type. It is also Entity class
 * which is stored inside of a database.
 *
 * @author Maciej-Musiał
 * @version 3.1
 * @param <T> generic type which represents the type of matrix's elements
 * extending {@link java.lang.Number} class
 */
@Entity
public class Matrix<T extends Number> implements IMatrix<T>, Serializable {

    /**
     * Field containing thse serial version of UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Field containing ID of the
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Field storing the type of class T.
     */
    private Class<T> classType;

    /**
     * Integer value. Represents a height of matrix.
     */
    private int height;

    /**
     * Integer value. Represents a width of matrix.
     */
    private int width;

    /**
     * Table 2D of T objects. Represents values of matrix.
     */
    private ArrayList<ArrayList<T>> matrixValues;

    /**
     * Non-parameter Matrix constructor.
     */
    public Matrix() {
        height = 0;
        width = 0;
        matrixValues = new ArrayList<>();
    }

    /**
     * Matrix constructor. Initiates
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object using height and
     * width parameters along with type class of T.
     *
     * @param a integer value - represents height
     * @param b integer value - represents width
     * @param type type of the elements stored inside
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     */
    public Matrix(int a, int b, Class<T> type) {
        height = a;
        width = b;
        matrixValues = new ArrayList<ArrayList<T>>();
        classType = type;
        initializeMatrixValues(createDefaultValue());
    }

    /**
     * Matrix constructor. Initiates
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object using height and
     * width, class type and value parameters.
     *
     * @param a integer value - represents height
     * @param b integer value - represents width
     * @param type type of the elements stored inside
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     * @param value initializing value of every matrix element
     */
    public Matrix(int a, int b, Class<T> type, T value) {
        height = a;
        width = b;
        matrixValues = new ArrayList<>();
        classType = type;
        initializeMatrixValues(value);
    }

    /**
     * Private method used by three-parameter constructor to get the default
     * value when it is not passed by.
     *
     * @return zero value of T type for all {@link java.lang.Number} types
     */
    private T createDefaultValue() {
        try {
            return classType.getConstructor(String.class).newInstance("0");
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            return null;
        }
    }

    /**
     * Private method used by parameter constructors to initialize values of
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object.
     *
     * @param value value of T type used for initialization
     */
    private void initializeMatrixValues(T value) {
        for (int i = 0; i < height; i++) {
            matrixValues.add(new ArrayList<>());
            for (int j = 0; j < width; j++) {
                matrixValues.get(i).add(value);
            }
        }
    }

    /**
     * Returns ID of {@link pl.polsl.matrixcalculatorweb.model.Matrix} object.
     *
     * @return ID of {@link pl.polsl.matrixcalculatorweb.model.Matrix} object.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets ID of {@link pl.polsl.matrixcalculatorweb.model.Matrix} object using
     * a parameter.
     *
     * @param id new ID of {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns height of {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object.
     *
     * @return height of {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Returns width of {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object.
     *
     * @return width of {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns class type of T object.
     *
     * @return class type of T object
     */
    @Override
    public Class<T> getClassType() {
        return classType;
    }

    /**
     * Returns table 2D of T objects.
     *
     * @return table 2D of T objects.
     */
    public ArrayList<ArrayList<T>> getMatrixValues() {
        return matrixValues;
    }

//    /**
//     * Overridden method. Returns a string matching the pattern: [row, column] =
//     * value.
//     *
//     * @return string matching the pattern: [row, column] = value
//     */
//    @Override
//    public String toString() {
//        int i = 0;
//        int j = 0;
//        String result = "";
//        for (ArrayList<T> row : getMatrixValues()) {
//            for (T el : row) {
//                Integer rowPosition = i + 1;
//                Integer columnPosition = j + 1;
//                result = result.concat("[".concat(rowPosition.toString().concat(", ".concat(columnPosition.toString().concat("] = ".concat(el.toString().concat("\n")))))));
//                j++;
//            }
//            j = 0;
//            i++;
//        }
//        result = result.substring(0, result.length() - 1);
//        return result;
//    }
    
    /**
     * Returns T object stored in passed position.
     *
     * @param column integer value representing a column
     * @param row integer value representing a row
     * @return T object stored in passed position
     * @throws DimensionException when refernces are null values or row and
     * column values are invalid
     */
    @Override
    public T getMatrixValue(int row, int column) throws DimensionException {
        if (row < 0 || column < 0) {
            throw new DimensionException("Numer kolumny i numer wiersza muszą być co najmniej równe 0!");
        } else if (row > height - 1 || column > width - 1) {
            throw new DimensionException("Wskazany numer kolumny lub wiersza wychodzi poza zakres wymiarów macierzy!");
        }
        return matrixValues.get(row).get(column);
    }

    /**
     * Changes matrix's element to value passed by parameter on specified
     * position.
     *
     * @param column integer value representing a column
     * @param row integer value representing a row
     * @param value T object representing the value of that type
     * @throws DimensionException when refernces are null values or row and
     * column values are invalid
     */
    @Override
    public void changeMatrixValue(int row, int column, T value) throws DimensionException {
        if (value == null) {
            throw new DimensionException("Niezainicjalizowana wartość parametru!");
        } else if (row < 0 || column < 0) {
            throw new DimensionException("Numer kolumny i numer wiersza muszą być co najmniej równe 0!");
        } else if (row > height - 1 || column > width - 1) {
            throw new DimensionException("Wskazany numer kolumny lub wiersza wychodzi poza zakres wymiarów macierzy!");
        }
        matrixValues.get(row).set(column, value);
    }

    /**
     * Overridden method used for serialization of the class.
     *
     * @return hash code of the object
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Overridden method used for serialization of the class.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matrix)) {
            return false;
        }
        Matrix other = (Matrix) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Overridden method used for serialization of the class.
     *
     * @return string object differencing objects of the same class
     */
    @Override
    public String toString() {
        return "pl.polsl.matrixcalculatorweb.model.Matrix[ id=" + id + " ]";
    }

}
