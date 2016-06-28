package com.app;

import java.util.Date;

/**
 * Created by Bartek on 2016-06-22.
 */
public abstract class Przedmiot <T>{

    public abstract void wyswietl();

    public abstract void dodaj_date();
    public abstract void setNazwa(String nazwa);
    public abstract void setWaga(double wagaa);
    public abstract void setUnique();
    public abstract String getNazwa();
    public abstract String getRodzaj();
    public abstract Date getData_waznosci();
    public abstract double getWaga();
    public abstract double getUnique();
    public abstract String getUnique2();



}
