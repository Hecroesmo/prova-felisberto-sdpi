package edu.ucan.vendaImoveis.model;

/**
 * @author tio-hecro
 */

public class Region {
    private int pkRegion;
    private String name;
    private int fkRegion;
    
    public Region() {}
    
    public int getPkRegion() {
        return pkRegion;
    }
    
    public void setPkRegion(int pkRegion) {
        this.pkRegion = pkRegion;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getFkRegion() {
        return fkRegion;
    }

    public void setFkRegion(int fkRegion) {
        this.fkRegion = fkRegion;
    }

    @Override
    public String toString() {
        return "Region{" + "pkRegion=" + pkRegion + ", name=" + name +
            ", fkRegion=" + fkRegion + '}';
    }
    
    
}
