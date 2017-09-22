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
 * Ova klasa sluzi kao model za glasaca koja se prevodi u tabelu u bazi putem Hibernate-a
 * Svi field-ovi unutar ove klase predstavljaju kolone u tabeli
 **/

@Entity
@Table(name = "glasac")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Glasac implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "jmbg")
    private String jmbg;

    @Column(name = "opcina")
    private String opcina;

    @Column(name = "glasao")
    private boolean glasao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getOpcina() {
        return opcina;
    }

    public void setOpcina(String opcina) {
        this.opcina = opcina;
    }

    public boolean isGlasao() {
        return glasao;
    }

    public void setGlasao(boolean glasao) {
        this.glasao = glasao;
    }

    @Override
    public String toString() {
        return "Glasac{" + "id=" + id + ", jmbg='" + jmbg + '\'' + ", opcina='" + opcina + '\'' + ", glasao=" + glasao + '}';
    }
}
