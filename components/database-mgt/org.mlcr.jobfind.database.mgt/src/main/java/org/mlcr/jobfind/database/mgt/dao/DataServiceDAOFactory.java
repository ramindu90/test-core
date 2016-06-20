package org.mlcr.jobfind.database.mgt.dao;

import org.mlcr.jobfind.database.mgt.dao.impl.DataServiceDABImpl;
import org.mlcr.jobfind.database.mgt.exception.IllegalConnectionException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ramindu on 6/12/16.
 */
public class DataServiceDAOFactory {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> currentConnection = new ThreadLocal<>();

    public static DataServiceDAO getDataServiceDAO() {
        return new DataServiceDABImpl();
    }



    public static void openConnection() throws SQLException, ClassNotFoundException {
        Connection conn = currentConnection.get();
        if (conn != null) {
            throw new IllegalConnectionException();
        }
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/geoLocationDB?user=root&password=root");
        currentConnection.set(conn);
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = currentConnection.get();
        if (conn == null) {
            throw new IllegalConnectionException();
        }
        return conn;
    }

    public static void closeConnection() {
        Connection conn = currentConnection.get();
        if (conn == null) {
            throw new IllegalConnectionException();
        }
        try {
            conn.close();
        } catch (SQLException e) {
//            log.warn("Error occurred while close the connection.");
        }
        currentConnection.remove();
    }
}
