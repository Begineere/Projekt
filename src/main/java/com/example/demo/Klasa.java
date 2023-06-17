package com.example.demo;

import java.sql.Date;

public class Klasa {
    private String Imie;
    private String Nazw;
    private Float cena;
    private Date date;
    private Float ilosc;
    private boolean status;
    public Klasa(){
        super();
    }

    public Klasa(String Imie, String Nazw, Float cena, Date date, Float ilosc, boolean status) {
        this.Imie = Imie;
        this.Nazw = Nazw;
        this.cena = cena;
        this.ilosc = ilosc;
        this.date = date;
        this.status = status;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazw() {
        return Nazw;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setNazw(String nazw) {
        Nazw = nazw;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getIlosc() {
        return ilosc;
    }

    public void setIlosc(Float ilosc) {
        this.ilosc = ilosc;
    }
}
