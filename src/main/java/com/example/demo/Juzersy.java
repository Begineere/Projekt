package com.example.demo;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Juzersy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column private String Imie;
    @Column private String Nazw;
    @Column private Float cena;
    @Column private Date date;
    @Column private Float ilosc;
    @Column private Float DoZaplaty;
    @Column private Long status;

    public Juzersy(){
        super();
    }

    public Juzersy(String imie, String nazw, Float cena, Date date, Float ilosc, Float DoZaplaty, Long status){
        this.Imie = imie;
        this.Nazw = nazw;
        this.cena = cena;
        this.date = date;
        this.ilosc = ilosc;
        this.DoZaplaty = DoZaplaty;
        this.status = status;
    }

    public void setIlosc(Float ilosc) {
        this.ilosc = ilosc;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setNazw(String nazw) {
        Nazw = nazw;
    }

    public Float getDoZaplaty() {
        return DoZaplaty;
    }

    public void setDoZaplaty(Float doZaplaty) {
        DoZaplaty = doZaplaty;
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
}
