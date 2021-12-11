package edu.ucan.vendaImoveis.model;

/**
 * @author tio-hecro
 */

// nº de assualhadas (T1, T2, ... etc)
public class SquashedNumber {
    private int pk_SquashedNumber;
    private int number; // devia ser String mais prontos...
    
    public SquashedNumber() {}
    
    public int getPkSquashedNumber () {
        return this.pk_SquashedNumber;
    }
    
    public void setPkSquashedNumber(int pkSquashedNumber) {
        this.pk_SquashedNumber = pkSquashedNumber;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(int description) {
        this.number = description;
    }

    @Override
    public String toString() {
        return "SquashedNumber{" + "pk_SquashedNumber=" + pk_SquashedNumber +
            ", number=" + number + '}';
    }
    
    
}
