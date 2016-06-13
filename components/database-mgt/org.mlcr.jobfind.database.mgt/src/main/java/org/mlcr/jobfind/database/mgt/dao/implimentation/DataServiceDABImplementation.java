package org.mlcr.jobfind.database.mgt.dao.implimentation;

import org.apache.log4j.Logger;
import org.mlcr.jobfind.database.mgt.bean.Application;
import org.mlcr.jobfind.database.mgt.dao.DataServiceDAO;
import org.mlcr.jobfind.database.mgt.dao.DataServiceDAOFactory;
import org.mlcr.jobfind.database.mgt.exception.DALException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Ramindu on 6/12/16.
 */
public class DataServiceDABImplementation implements DataServiceDAO {
    final static Logger log = Logger.getLogger(DataServiceDABImplementation.class);

    public void registerApplicant(Application application) throws SQLException {
        Connection con;
        PreparedStatement stmt = null;
        try{
            con = this.getConnection();
            String sql = "INSERT INTO applicants_table values (?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "sample");
            stmt.executeUpdate();
        } finally {
            cleanupResources(stmt);
        }
    }

    private Connection getConnection() throws SQLException {
        return DataServiceDAOFactory.getConnection();
    }

    private void cleanupResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.warn("Error occurred while closing result set", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.warn("Error occurred while closing prepared statement", e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                log.warn("Error occurred while closing database connection", e);
            }
        }
    }

    private void cleanupResources(PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                log.warn("Error occurred while closing result set", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.warn("Error occurred while closing prepared statement", e);
            }
        }
    }

    private void cleanupResources(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                log.warn("Error occurred while closing prepared statement", e);
            }
        }
    }
}
