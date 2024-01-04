// definition of the package in which class is placed
package pl.polsl.matrixcalculatorweb.model;

// packages containing class definitions
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import java.util.List;

/**
 * A class in the 'model' package. The class is responsible for connecting with
 * a database and doing operations on it.
 *
 * @author Maciej-Musiał
 * @version 1.2
 */
public class DBManager {

    /**
     * Factory of EntityManager's objects responsible for getting connection
     * with a ddatabase.
     */
    EntityManagerFactory emf;

    /**
     * Non-parameter constructor. It gets connection using persistence unit
     * name.
     */
    public DBManager() {
        emf = Persistence.createEntityManagerFactory("pl.polsl_MatrixCalculatorWeb_jar_1.0-SNAPSHOTPU");
    }

    /**
     * Method used to persist an object passed by a parameter in a database.
     *
     * @param object object to persist
     * @throws PersistenceException exception thrown when persist operation did
     * not work
     */
    public void persist(Object object) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    /**
     * Method used to get list of Calculation objects stored in a database.
     *
     * @return list of Calculation objects
     * @throws PersistenceException exception thrown when select operation did
     * not work
     */
    public List<Calculation> findCalculations() throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Calculation> calculationList = null;
        try {
            Query query = em.createQuery("select c from Calculation c");
            calculationList = query.getResultList();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
            return calculationList;
        }
    }

    /**
     * Method used to truncate a table passed by paramater in a database.
     *
     * @param tableName name of the table to truncate
     * @throws PersistenceException exception thrown when truncate operation did
     * not work
     */
    public void truncateTable(String tableName) throws PersistenceException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("delete from " + tableName + " t").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}
