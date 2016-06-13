package org.mlcr.jobfind.database.mgt.implementation;

import org.mlcr.jobfind.database.mgt.JobFindDataService;
import org.mlcr.jobfind.database.mgt.bean.Application;
import org.mlcr.jobfind.database.mgt.dao.DataServiceDAOFactory;
import org.mlcr.jobfind.database.mgt.exception.DALException;
import org.mlcr.jobfind.database.mgt.exception.InvalidOrganizationOptionException;

import java.sql.SQLException;
import java.util.List;


public class JobFindDataServiceImplimentation implements JobFindDataService{
    public void registerApplicant(Application application) throws DALException {
        try {
            DataServiceDAOFactory.openConnection();
            DataServiceDAOFactory.getDataServiceDAO().registerApplicant(application);
        } catch (SQLException e) {
            throw new DALException();
        } catch (ClassNotFoundException e) {
            throw new DALException();
        } finally {
            DataServiceDAOFactory.closeConnection();
        }
    }
}
