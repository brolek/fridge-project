package com.app;

import java.util.Date;

public class Memento {
    private String nazwa;
    private String rodzaj;
    private Date data;
    private double waga;


    public Memento(String nazwaa,String rodzajj,Date dataa,double wagaa)
    {
        nazwa=nazwaa;
        rodzaj=rodzajj;
        data=dataa;
        waga=wagaa;
    }
    public String getNazwa()
    {
        return nazwa;
    }
    public String getRodzaj()
    {
        return rodzaj;
    }
    public Date getData(){
        return data;
    }
    public double getWaga(){
        return waga;
    }

}
