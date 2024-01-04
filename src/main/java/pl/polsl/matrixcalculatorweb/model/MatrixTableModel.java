// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

// packages containing class definitions
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * A class in the 'model' package. The class represents a model of table
 * containing matrix's data passed by user. The class extends AbstractTableModel
 * class.
 *
 * @author Maciej-Musiał
 * @version 1.2
 * @param <T> generic type which represents the type of matrix's elements
 * extending {@link java.lang.Number} class
 */
public class MatrixTableModel<T extends Number> extends AbstractTableModel {

    /**
     * Field storing the type of class T.
     */
    private Class<T> classType;

    /**
     * Integer value. Represents a width of matrix.
     */
    private int height;

    /**
     * Table 2D of T objects. Represents values of matrix.
     */
    private int width;

    /**
     * Integer value. Represents a height of matrix.
     */
    private ArrayList<ArrayList<T>> data;

    /**
     * MatrixTableModel constructor. Initiates
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object using type
     * class of T parameter.
     *
     * @param type type of the elements stored inside
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object
     */
    public MatrixTableModel(Class<T> type) {
        height = 1;
        width = 1;
        classType = type;
        data = new ArrayList<>();
        initializeMatrixValues(createDefaultValue());
    }

    /**
     * MatrixTableModel constructor. Initiates
     * {@link pl.polsl.matrixcalculatorweb.model.MatrixTableModel} object using height
     * and width parameters along with type class of T.
     *
     * @param a integer value - represents height
     * @param b integer value - represents width
     * @param type type of the elements stored inside
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     */
    public MatrixTableModel(int a, int b, Class<T> type) {
        height = a;
        width = b;
        classType = type;
        data = new ArrayList<>();
        initializeMatrixValues(createDefaultValue());
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
            data.add(new ArrayList<>());
            for (int j = 0; j < width; j++) {
                data.get(i).add(value);
            }
        }
    }

    /**
     * Overriden method returning number of columns inside of table.
     *
     * @return number of columns
     */
    @Override
    public int getColumnCount() {
        return width;
    }

    /**
     * Overriden method returning number of rows inside of table.
     *
     * @return number of rows
     */
    @Override
    public int getRowCount() {
        return height;
    }

    /**
     * Overriden method returning name of column (null value) described by
     * specified index.
     *
     * @return null value
     */
    @Override
    public String getColumnName(int col) {
        return null;
    }

    /**
     * Returns object stored in passed position.
     *
     * @param row integer value representing a row
     * @param col integer value representing a column
     * @return object stored in passed position
     */
    @Override
    public Object getValueAt(int row, int col) {
        return data.get(col).get(row);
    }

    /**
     * Overridden method returning a class of object stored in a column selected
     * by parameter.
     *
     * @param c index of selected column
     * @return class object of type stored in a column
     */
    @Override
    public Class<?> getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /**
     * Overridden method used to select editable cells. In this case it always
     * returns true value.
     *
     * @param row integer value representing a row
     * @param col integer value representing a column
     * @return true value
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //uwaga - adres komorki jest staly, niezaleznie
        //od aktualnego polozenia na ekranie
        return true;
    }

    /**
     * Overidden method used to change value of cell. It sends the signal to
     * update the view of table structure.
     *
     * @param value value of object type passed by user
     * @param row integer value representing a row
     * @param col integer value representing a column
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        //wlasciwa aktualizacja
        data.get(col).set(row, (T) value);
        //wywolanie metody generujacej zdarzenie informujace
        //o zmianie zawartosci komorki
        fireTableCellUpdated(row, col);
    }

    /**
     * Method used to add a column to the model. It sends the signal to update
     * the view of table structure.
     */
    public void addColumn() {
        data.add(new ArrayList<>());
        for (int i = 0; i < height; i++) {
            data.get(width).add(createDefaultValue());
        }
        width++;
        fireTableStructureChanged();
    }

    /**
     * Method used to add a row to the model. It sends the signal to update the
     * view of table structure.
     */
    public void addRow() {
        for (int i = 0; i < width; i++) {
            data.get(i).add(createDefaultValue());
        }
        height++;
        fireTableRowsInserted(getRowCount(), getRowCount());
    }

    /**
     * Method used to remove a column of the model. It sends the signal to
     * update the view of table structure.
     *
     * @throws DimensionException object when number of columns equals 0 already
     */
    public void removeColumn() throws DimensionException {
        if (width == 0) {
            throw new DimensionException("Szerokość tablicy jest równa 0!");
        }

        data.remove(width - 1);
        width--;
        fireTableStructureChanged();
    }

    /**
     * Method used to remove a row of the model. It sends the signal to update
     * the view of table structure.
     *
     * @throws DimensionException object when number of rows equals 0 already
     */
    public void removeRow() throws DimensionException {
        if (height == 0) {
            throw new DimensionException("Wysokość tablicy jest równa 0!");
        }

        for (int i = 0; i < width; i++) {
            data.get(i).remove(height - 1);
        }
        height--;
        fireTableRowsDeleted(getRowCount(), getRowCount());
    }
}
