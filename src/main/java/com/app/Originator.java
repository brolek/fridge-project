package com.app;

import java.util.Date;

/**
 * Created by Bartek on 2016-07-05.
 */
public class Originator {
    private String nazwa;
    private String rodzaj;
    private Date data;
    private double waga;

    public void setNazwa(String nazwaa)
    {
        nazwa=nazwaa;
    }
    public void setRodzaj(String rodzajj)
    {
        rodzaj=rodzajj;
    }
    public void setData(Date dataa)
    {

            data = dataa;

    }
    public void setWaga(double wagaa)
    {
        waga=wagaa;
    }

    public Memento zapisz(){
        return new Memento(nazwa,rodzaj,data,waga);
    }
    public String odczytaj(Memento obiekt)
    {
        return "obiekt o nazwie "+ nazwa + ", rodzaju: "+ rodzaj + ", dacie ważności: " + data + ", i wadze: " + waga+ ". ";
    }

}


