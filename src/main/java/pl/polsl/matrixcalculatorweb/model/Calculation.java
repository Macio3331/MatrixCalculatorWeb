// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

// packages containing class definitions 
import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * A class in the 'model' package. The class implements Serializable interface
 * and represents a calculation of made by a user. It is also Entity class which
 * is stored inside of a database.
 *
 * @author Maciej-Musiał
 * @version 1.1
 */
@Entity
public class Calculation implements Serializable {

    /**
     * Field containing thse serial version of UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Field containing ID of the
     * {@link pl.polsl.matrixcalculatorweb.model.Calculation} object.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Field storing the first {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object. It also stores key value of Matrix table inside of a database.
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private Matrix firstMatrix;

    /**
     * Field storing the second
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object. It also stores
     * key value of Matrix table inside of a database.
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private Matrix secondMatrix;

    /**
     * Field storing the result
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object. It also stores
     * key value of Matrix table inside of a database.
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    private Matrix resultMatrix;

    /**
     * String object containing information about which operation was chosen by
     * a user.
     */
    private String operation;

    /**
     * Non-parameter constructor.
     */
    public Calculation() {
        firstMatrix = new Matrix();
        secondMatrix = new Matrix();
        resultMatrix = new Matrix();
        operation = "";
    }

    /**
     * Calculation constructor. Initiates
     * {@link pl.polsl.matrixcalculatorweb.model.Calculation} object using three
     * matrices along with operation chosen by a user.
     *
     * @param first {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     * @param second {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     * @param result {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     * @param op String object representing user's choice of operation
     * {@link pl.polsl.matrixcalculatorweb.model.Matrix} object
     */
    public Calculation(Matrix first, Matrix second, Matrix result, String op) {
        firstMatrix = first;
        secondMatrix = second;
        resultMatrix = result;
        operation = op;
    }

    /**
     * Returns ID of {@link pl.polsl.matrixcalculatorweb.model.Calculation}
     * object.
     *
     * @return ID of {@link pl.polsl.matrixcalculatorweb.model.Calculation}
     * object.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets ID of {@link pl.polsl.matrixcalculatorweb.model.Calculation} object
     * using a parameter.
     *
     * @param id new ID of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculation} object
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the first {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object.
     *
     * @return the firstMatrix
     */
    public Matrix getFirstMatrix() {
        return firstMatrix;
    }

    /**
     * Sets the first {@link pl.polsl.matrixcalculatorweb.model.Matrix} object.
     *
     * @param firstMatrix the firstMatrix to set
     */
    public void setFirstMatrix(Matrix firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    /**
     * Returns the second {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object.
     *
     * @return the secondMatrix
     */
    public Matrix getSecondMatrix() {
        return secondMatrix;
    }

    /**
     * Sets the second {@link pl.polsl.matrixcalculatorweb.model.Matrix} object.
     *
     * @param secondMatrix the secondMatrix to set
     */
    public void setSecondMatrix(Matrix secondMatrix) {
        this.secondMatrix = secondMatrix;
    }

    /**
     * Returns the result {@link pl.polsl.matrixcalculatorweb.model.Matrix}
     * object.
     *
     * @return the resultMatrix
     */
    public Matrix getResultMatrix() {
        return resultMatrix;
    }

    /**
     * Sets the result {@link pl.polsl.matrixcalculatorweb.model.Matrix} object.
     *
     * @param resultMatrix the resultMatrix to set
     */
    public void setResultMatrix(Matrix resultMatrix) {
        this.resultMatrix = resultMatrix;
    }

    /**
     * Returns the operation stored inside of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculation} object.
     *
     * @return the operation
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the operation stored inside of
     * {@link pl.polsl.matrixcalculatorweb.model.Calculation} object.
     *
     * @param operation the operation to set
     */
    public void setOperation(String operation) {
        this.operation = operation;
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
        if (!(object instanceof Calculation)) {
            return false;
        }
        Calculation other = (Calculation) object;
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
        return "pl.polsl.matrixcalculatorweb.model.Calculation[ id=" + id + " ]";
    }

}
