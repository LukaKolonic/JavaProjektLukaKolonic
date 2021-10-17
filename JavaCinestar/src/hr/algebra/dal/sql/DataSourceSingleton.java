/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;

/**
 *
 * @author lukak
 */
public class DataSourceSingleton {
    
    private static final String PASS = "SQL";
    private static final String DATABASE = "JavaBaza";
    private static final String SERVER ="localhost";
    private static final String USER = "sas";
    
    private static DataSource instance; 

   
    
    private DataSourceSingleton() { 
    } 

    public static DataSource getInstance() {
        if (instance == null) {    
            instance = createInstance();
        }
        
        return instance;
    }
    
    
    private static DataSource createInstance() {    //centralizacija
        SQLServerDataSource dataSource = new SQLServerDataSource();
        
        dataSource.setServerName(SERVER);
        dataSource.setDatabaseName(DATABASE);
        dataSource.setUser(USER);
        dataSource.setPassword(PASS);
        
        return dataSource;
    }
    
}
