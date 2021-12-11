package edu.ucan.vendaImoveis.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author tio-hecro
 */

public class ConnectionFactory {
    public Connection getConnection (){
        try 
        {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/VendaImoveis",
                    "postgres", "postgres");
        } 
        catch (SQLException | ClassNotFoundException ex) 
        {
            throw new RuntimeException("Fail to connect to database", ex);
        }
    }
}
