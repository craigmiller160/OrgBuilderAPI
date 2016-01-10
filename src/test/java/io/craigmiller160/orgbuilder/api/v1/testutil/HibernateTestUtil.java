package io.craigmiller160.orgbuilder.api.v1.testutil;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * A special utility class to allow Hibernate
 * to reset the auto-increment counters in
 * the database. Currently only implemented
 * to work with MySQL, as the command requires
 * database-dialect specific SQL.
 *
 * Created by Craig on 1/10/2016.
 */
@Component ("hibernateTestUtil")
@Transactional
public class HibernateTestUtil {

    /**
     * The SessionFactory class used to access the
     * database.
     */
    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateTestUtil(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    /**
     * Reset the auto-increment counter on
     * the database table for the Person class.
     *
     * @throws HibernateException if Hibernate is unable to
     *                  execute the query.
     * @throws UnsupportedOperationException if the database
     *                  being used is not MySQL.
     */
    public void resetPersonAutoIncrement(){
        if(isMySQLDialect()){
            executeResetAutoIncrement("people");
        }
        else{
            throw new UnsupportedOperationException(
                    "Method is only compatible with MySQL database");
        }
    }

    /**
     * Reset the auto-increment counter on
     * the database table for the PersonAddress class.
     *
     * @throws HibernateException if Hibernate is unable to
     *                  execute the query.
     * @throws UnsupportedOperationException if the database
     *                  being used is not MySQL.
     */
    public void resetPersonAddressAutoIncrement(){
        if(isMySQLDialect()){
            executeResetAutoIncrement("people_addresses");
        }
        else{
            throw new UnsupportedOperationException(
                    "Method is only compatible with MySQL database");
        }
    }

    /**
     * Reset the auto-increment counter on
     * the database table for the PersonPhone class.
     *
     * @throws UnsupportedOperationException if the database
     *                  being used is not MySQL.
     * @throws HibernateException if Hibernate is unable to
     *                  execute the query.
     */
    public void resetPersonPhoneAutoIncrement(){
        if(isMySQLDialect()){
            executeResetAutoIncrement("people_phones");
        }
        else{
            throw new UnsupportedOperationException(
                    "Method is only compatible with MySQL database");
        }
    }

    /**
     * Reset the auto-increment counter on
     * the database table for the PersonEmail class.
     *
     * @throws UnsupportedOperationException if the database
     *                  being used is not MySQL.
     * @throws HibernateException if Hibernate is unable to
     *                  execute the query.
     */
    public void resetPersonEmailAutoIncrement(){
        if(isMySQLDialect()){
            executeResetAutoIncrement("people_emails");
        }
        else{
            throw new UnsupportedOperationException(
                    "Method is only compatible with MySQL database");
        }
    }

    /**
     * Convenience method to reset the counters on
     * all tables for Person-related entities
     * with a single method call/transaction.
     *
     * @throws HibernateException if Hibernate is unable to
     *                  execute the query.
     * @throws HibernateException if Hibernate is unable to
     *                  execute the query.
     */
    public void resetAllPersonEntityAutoIncrement(){
        resetPersonAutoIncrement();
        resetPersonAddressAutoIncrement();
        resetPersonEmailAutoIncrement();
        resetPersonPhoneAutoIncrement();
    }

    /**
     * Get the SQL Dialect used by the current
     * SessionFactory.
     *
     * @return the SQL Dialect used by the current
     * SessionFactory.
     */
    private Dialect getDialect(){
        return ((SessionFactoryImplementor) sessionFactory).getDialect();
    }

    /**
     * Test if the SQL Dialect used by the current
     * SessionFactory is for MySQL.
     *
     * @return true if the dialect is for MySQL.
     */
    private boolean isMySQLDialect(){
        return getDialect() instanceof MySQLDialect;
    }

    /**
     * Create the SQL Query for resetting the counter
     * in the specified table.
     *
     * @param tableName the name of the table to reset
     *                  the counter for.
     * @return the query to reset the counter of the table.
     */
    private String createQuery(String tableName){
        return "alter table " + tableName + " auto_increment = 1";
    }

    /**
     * Use the SessionFactory to execute a reset operation
     * on the auto-increment counter of the specified
     * table.
     *
     * @param tableName the table to reset the counter on.
     * @throws HibernateException if Hibernate is unable to
     *                  execute the query.
     */
    private void executeResetAutoIncrement(String tableName){
        sessionFactory.getCurrentSession()
                .createSQLQuery(createQuery(tableName))
                .executeUpdate();
    }

}
