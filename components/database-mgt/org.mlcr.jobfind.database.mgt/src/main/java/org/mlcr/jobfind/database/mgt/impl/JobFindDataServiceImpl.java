package org.mlcr.jobfind.database.mgt.impl;

import org.mlcr.jobfind.database.mgt.JobFindDataService;
import org.mlcr.jobfind.database.mgt.bean.Application;
import org.mlcr.jobfind.database.mgt.dao.DataServiceDAOFactory;
import org.mlcr.jobfind.database.mgt.exception.DALException;

import java.sql.SQLException;

public class JobFindDataServiceImpl implements JobFindDataService{
    public void registerApplicant(Application application) throws DALException {
        try {
            DataServiceDAOFactory.openConnection();
            DataServiceDAOFactory.getDataServiceDAO().registerApplicant(application);
            DataServiceDAOFactory.closeConnection();
        } catch (SQLException e) {
            throw new DALException();
        } catch (ClassNotFoundException e) {
            throw new DALException();
        } finally {
            DataServiceDAOFactory.closeConnection();
        }
    }
}
