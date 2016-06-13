package org.mlcr.jobfind.database.mgt.dao;

import org.mlcr.jobfind.database.mgt.bean.Application;
import org.mlcr.jobfind.database.mgt.exception.DALException;

import java.sql.SQLException;

/**
 * Created by Ramindu on 6/12/16.
 */
public interface DataServiceDAO {
    void registerApplicant(Application application) throws SQLException;
}
