package edu.ucan.vendaImoveis.model;

/**
 * @author tio-hecro
 */
public class Person {
    private String biNumber;
    private String name;
    private String phoneNumber;
    private Region province;
    private Region municipality;
    private Region commune;
    private Region neighborhood;
    
    public Person () {}

    public String getBiNumber() {
        return biNumber;
    }

    public void setBiNumber(String biNumber) {
        this.biNumber = biNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "Person{" + "biNumber=" + biNumber + ", name=" + name +
            ", phoneNumber=" + phoneNumber + ", province=" + province +
            ", municipality=" + municipality + ", commune=" + commune +
            ", neighborhood=" + neighborhood + '}';
    }
    
    
}
