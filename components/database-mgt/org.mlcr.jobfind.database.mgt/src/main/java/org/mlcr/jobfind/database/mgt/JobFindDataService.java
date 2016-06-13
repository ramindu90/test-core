package org.mlcr.jobfind.database.mgt;

import org.mlcr.jobfind.database.mgt.bean.Application;
import org.mlcr.jobfind.database.mgt.exception.DALException;

/**
 * This interface exposes useful service layer functions to retrieve data
 * required by high level dashboard APIs.
 */
public interface JobFindDataService {

    /**
     * This method is used to get organizations for a defined filter set.
     * @param application
     * @throws DALException                         This can occur due to errors connecting to database,
     *                                              executing SQL query and retrieving data.
     */
    void registerApplicant(Application application) throws DALException;
}
