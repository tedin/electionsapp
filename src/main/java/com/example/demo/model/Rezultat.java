package com.example.demo.model;

import org.springframework.stereotype.Component;

/**
 * Created by edin on 22.9.2017..
 * DTO klasa za obradu rezultata
 */
@Component
public class Rezultat {

    private String stranka;
    private int brojglasova;

    public String getStranka() {
        return stranka;
    }

    public void setStranka(String stranka) {
        this.stranka = stranka;
    }

    public int getBrojglasova() {
        return brojglasova;
    }

    public void setBrojglasova(int brojglasova) {
        this.brojglasova = brojglasova;
    }

    @Override
    public String toString() {
        return "Rezultat{" + "stranka='" + stranka + '\'' + ", brojglasova=" + brojglasova + '}';
    }
}
