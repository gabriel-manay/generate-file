package com.accenture.model;

import javax.persistence.*;

@Entity
@Table(name = "bines052")
public class Bines052 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clave;
    private String identab;
    private String bintar;
    private String denoban;
    private String idenban;

    public Bines052() {
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getIdentab() {
        return identab;
    }

    public void setIdentab(String identab) {
        this.identab = identab;
    }

    public String getBintar() {
        return bintar;
    }

    public void setBintar(String bintar) {
        this.bintar = bintar;
    }

    public String getDenoban() {
        return denoban;
    }

    public void setDenoban(String denoban) {
        this.denoban = denoban;
    }

    public String getIdenban() {
        return idenban;
    }

    public void setIdenban(String idenban) {
        this.idenban = idenban;
    }

    @Override
    public String toString() {
        return clave + " "  + identab + " " + bintar + " " + denoban + " " + idenban;
    }
}
