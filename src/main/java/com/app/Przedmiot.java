package com.app;

import java.util.Date;

public abstract class Przedmiot{
    public String rodzaj;

    public abstract void dodaj_date(String data);
    public abstract void setNazwa(String nazwa);
    public abstract void setWaga(double wagaa);
    public abstract void setUnique(double x);
    public abstract void setUnique2(String x);
    public abstract String getNazwa();
    public abstract String getRodzaj();
    public abstract Date getData_waznosci();
    public abstract double getWaga();
    public abstract double getUnique();
    public abstract String getUnique2();
    public void setRodzaj(String rodzajj){
        rodzaj=rodzajj;
    }



}
