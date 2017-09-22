package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by edin on 16.5.2017..
 * Ova klasa sluzi kao model za kandidata koja se prevodi u tabelu u bazi putem Hibernate-a
 * Svi field-ovi unutar ove klase predstavljaju kolone u tabeli
 **/

@Entity
@Table(name = "kandidat")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })

public class Kandidat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    @Column(name = "pozicija")
    private String pozicija;

    @Column(name = "opcina")
    private String opcina;

    @Column(name = "broj_glasova")
    private int brojGlasova;

    /*@ManyToOne
    @JoinColumn(name = "stranka")
    private Stranka stranka;*/
    @Column(name = "stranka")
    private String stranka;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    /*public Stranka getStranka() {
        return stranka;
    }

    public void setStranka(Stranka stranka) {
        this.stranka = stranka;
    }*/

    public String getOpcina() {
        return opcina;
    }

    public void setOpcina(String opcina) {
        this.opcina = opcina;
    }

    public int getBrojGlasova() {
        return brojGlasova;
    }

    public void setBrojGlasova(int brojGlasova) {
        this.brojGlasova = brojGlasova;
    }

    public String getStranka() {
        return stranka;
    }

    public void setStranka(String stranka) {
        this.stranka = stranka;
    }

    @Override
    public String toString() {
        return "Kandidat{" + "id=" + id + ", ime='" + ime + '\'' + ", prezime='" + prezime + '\'' + ", pozicija='" + pozicija + '\'' + ", opcina='"
                + opcina + '\'' + ", brojGlasova=" + brojGlasova + ", stranka=" + stranka + '}';
    }
}
