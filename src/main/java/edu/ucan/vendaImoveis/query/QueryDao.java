package edu.ucan.vendaImoveis.query;

import edu.ucan.vendaImoveis.model.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tio-hecro
 */
public class QueryDao {
    private final Connection connection;
    private PreparedStatement statement;
    
    public QueryDao (Connection connection) {
        this.connection = connection;
    }
    
    // Consulta 2.1
    public List getClientHouse(int squashedNumber) {
        String sql = "SELECT p.pk_bi_number, p.name FROM person p "
            + "JOIN client_house ch ON pk_bi_number = ch.fk_client "
            + "JOIN house h ON pk_house = ch.fk_house "
            + "JOIN squashed_number sn ON pk_squashed_number = h.fk_squashed_number "
            + "WHERE h.construction_year = date_part('year', ch.start_date) "
            + "AND ch.final_date is null and sn.number = ?";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, squashedNumber);
            
            ResultSet rs = statement.executeQuery();
            
            if (rs.next() == false) return null;
            
            List <Person> persons = new ArrayList<>();
            
            do 
            {
                Person person = new Person();
                person.setBiNumber(rs.getString("pk_bi_number"));
                person.setName(rs.getString("name"));
                persons.add(person);
            }
            while(rs.next());
            
            return persons;
        }
        catch (SQLException ex) {
            throw new RuntimeException("Fail to retrieve client houses", ex);
        }
    }
}
