package edu.ucan.test;

import edu.ucan.vendaImoveis.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author tio-hecro
 */
public class ConnectionFactoryTest {
    public static void main(String args[]) throws SQLException {
        try (Connection connection = new ConnectionFactory().getConnection()) {
            System.out.println("Works");
        }
    }
}
