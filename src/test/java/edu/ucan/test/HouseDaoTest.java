package edu.ucan.test;

import edu.ucan.vendaImoveis.connection.ConnectionFactory;
import edu.ucan.vendaImoveis.dao.HouseDao;
import edu.ucan.vendaImoveis.model.House;
import edu.ucan.vendaImoveis.model.Person;
import edu.ucan.vendaImoveis.model.Region;
import edu.ucan.vendaImoveis.model.SquashedNumber;
import edu.ucan.vendaImoveis.query.QueryDao;
import java.sql.Connection;

/**
 * @author tio-hecro
 */

public class HouseDaoTest {
    public static void main (String [] args) {
        
        SquashedNumber number = new SquashedNumber();
        number.setNumber(3);
        number.setPkSquashedNumber(1);
        //  ------------------------------------------------
        
        Region province = new Region();
        province.setPkRegion(1);
        province.setName("Luanda");
        
        Region municiplaity = new Region();
        municiplaity.setPkRegion(7);
        municiplaity.setName("Viana");
        municiplaity.setFkRegion(2);
        
        Region commune = new Region();
        commune.setPkRegion(5);
        commune.setName("Estalagem");
        commune.setFkRegion(2);
        
        Region neighborhood = new Region();
        neighborhood.setPkRegion(6);
        neighborhood.setName("Caope");
        neighborhood.setFkRegion(5);
        //-------------------------------
        
        Person person = new Person();
        person.setBiNumber("2343223LN34");
        person.setName("Marcos M Sweet");
        person.setPhoneNumber("948372949");
        person.setProvince(province);
        person.setMunicipality(municiplaity);
        person.setCommune(commune);
        person.setNeighborhood(neighborhood);
        
        //-------------------------------
        House house = new House();
        house.setSquashedNumber(number);
        house.setPrice(30000000);
        house.setContructionYear(1995);
        house.setProvince(province);
        house.setMunicipality(municiplaity);
        house.setCommune(commune);
        house.setNeighborhood(neighborhood);
        
        Connection connection = new ConnectionFactory().getConnection();
        HouseDao dao = new HouseDao(connection);
        QueryDao qdao = new QueryDao(connection);
        
        //  dao.save(house);
        
        System.out.println(qdao.getClientHouse(1));
        
    }
}
