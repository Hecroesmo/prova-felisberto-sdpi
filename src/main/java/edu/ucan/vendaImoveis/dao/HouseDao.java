package edu.ucan.vendaImoveis.dao;

import edu.ucan.vendaImoveis.model.House;
import edu.ucan.vendaImoveis.model.Person;
import edu.ucan.vendaImoveis.model.Region;
import edu.ucan.vendaImoveis.model.SquashedNumber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tio-hecro
 */

/*  Vale ressaltar q na folha de prova não precisa  escrever a class,
apenas os métodos */

public class HouseDao {
    private final Connection connection;
    private PreparedStatement statement;
    
    public HouseDao(Connection connection) {
        this.connection = connection;
    }
    
    public void alter (House house) {
        String sql = "UPDATE house set fk_squashed_number = ?, price = ?,"
            + " construction_year = ?, fk_province = ?, fk_municipality = ?,"
            + " fk_commune = ?, fk_neighborhood = ?, fk_person = ? WHERE pk_house = ?";
        
        try
        {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, house.getSquashedNumber().getPkSquashedNumber());
            statement.setDouble(2, house.getPrice());
            statement.setInt(3, house.getContructionYear());
            statement.setInt(4, house.getProvince().getPkRegion());
            statement.setInt(5, house.getMunicipality().getPkRegion());
            statement.setInt(6, house.getCommune().getPkRegion());
            statement.setInt(7, house.getNeighborhood().getPkRegion());
            statement.setString(8, house.getPerson().getBiNumber());
            statement.setInt(9, house.getPkHouse());
            statement.executeUpdate();
        }
        catch (SQLException ex) {
            throw new RuntimeException("Fail to alter house", ex);
        }
    }
    
    public List listAll () {
        String sql = "SELECT * FROM house";
        
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next() == false) return null;
            
            List<House> houses = new ArrayList<>();
                    
            do
            {
                House house = new House();
                house.setPkHouse(resultSet.getInt("pk_house"));
                SquashedNumber sn = new SquashedNumber();
                sn.setPkSquashedNumber(resultSet.getInt("fk_squashed_number"));
                house.setSquashedNumber(sn);
                house.setPrice(resultSet.getDouble("price"));
                house.setContructionYear(resultSet.getInt("construction_year"));
                
                Region province = new Region();
                province.setPkRegion(resultSet.getInt("fk_province"));
                
                Region municipality = new Region();
                municipality.setPkRegion(resultSet.getInt("fk_municipality"));
                
                Region commune = new Region();
                commune.setPkRegion(resultSet.getInt("fk_commune"));
                 
                Region neighborhood = new Region();
                neighborhood.setPkRegion(resultSet.getInt("fk_neighborhood"));
                
                Person person = new Person();
                person.setBiNumber(resultSet.getString("fk_person"));
                
                house.setProvince(province);
                house.setMunicipality(municipality);
                house.setCommune(commune);
                house.setNeighborhood(neighborhood);
                house.setPerson(person);
                
                houses.add(house);
            }
            while (resultSet.next());
            
            return houses;
        }
        catch(SQLException ex) {
            throw new RuntimeException("Fail to list houses", ex);
        }
        
    }
    
    public void save (House house) {
        String sql = "INSERT INTO house(fk_squashed_number, price,"
            + " construction_year, fk_province, fk_municipality,"
            + " fk_commune, fk_neighborhood, fk_person) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        
        try 
        {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, house.getSquashedNumber().getPkSquashedNumber());
            statement.setDouble(2, house.getPrice());
            statement.setInt(3, house.getContructionYear());
            statement.setInt(4, house.getProvince().getPkRegion());
            statement.setInt(5, house.getMunicipality().getPkRegion());
            statement.setInt(6, house.getCommune().getPkRegion());
            statement.setInt(7, house.getNeighborhood().getPkRegion());
            statement.setString(8, house.getPerson().getBiNumber());
            statement.executeUpdate();
            closeConnection();
        } 
        catch (SQLException ex) {
           throw new RuntimeException("Fail to save house", ex);
        }
    }
    
    private void closeConnection() throws SQLException {
        connection.close();
    }
}
