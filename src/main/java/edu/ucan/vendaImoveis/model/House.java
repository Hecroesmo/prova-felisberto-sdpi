package edu.ucan.vendaImoveis.model;

/**
 * @author tio-hecro
 */
public class House {
    private int pkHouse;
    private SquashedNumber squashedNumber;
    private double price;
    private int contructionYear;
    private Person person;
    private Region province;
    private Region municipality;
    private Region commune;
    private Region neighborhood;

    public House() {}

    public int getPkHouse() {
        return pkHouse;
    }

    public void setPkHouse(int pkHouse) {
        this.pkHouse = pkHouse;
    }

    public SquashedNumber getSquashedNumber() {
        return squashedNumber;
    }

    public void setSquashedNumber(SquashedNumber squashedNumber) {
        this.squashedNumber = squashedNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getContructionYear() {
        return contructionYear;
    }

    public void setContructionYear(int contructionYear) {
        this.contructionYear = contructionYear;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    

    public Region getProvince() {
        return province;
    }

    public void setProvince(Region province) {
        this.province = province;
    }

    public Region getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Region municipality) {
        this.municipality = municipality;
    }

    public Region getCommune() {
        return commune;
    }

    public void setCommune(Region commune) {
        this.commune = commune;
    }

    public Region getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(Region neighborhood) {
        this.neighborhood = neighborhood;
    }

    @Override
    public String toString() {
        return "House{" + "pkHouse=" + pkHouse + ", squashedNumber=" + squashedNumber + ", price=" + price + ", contructionYear=" + contructionYear + ", person=" + person + ", province=" + province + ", municipality=" + municipality + ", commune=" + commune + ", neighborhood=" + neighborhood + '}';
    }    
    
}
