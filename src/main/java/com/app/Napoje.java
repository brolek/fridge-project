package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Napoje extends Przedmiot {
    private String nazwa;
    private final String rodzaj = "napoje";
    private Date data_waznosci;
    private double waga;
    private double zawartosc_alkoholu;

    public void Napoje(String nazwaa,Date data,double wagaa,double procent)
    {
        nazwa=nazwaa;
        data_waznosci = data;
        waga = wagaa;
        zawartosc_alkoholu=procent;

    }
    public void setNazwa(String nazwaa)
    {
        nazwa = nazwaa;
    }

    public void setWaga(double wagaa)
    {
        waga = wagaa;
    }
    public void setUnique(double procent)
    {
        zawartosc_alkoholu =procent;
    }
    public void setUnique2(String x){};
    public double getUnique(){
        return zawartosc_alkoholu;
    }
    public String getUnique2(){return "";}

    public String getNazwa(){
        return nazwa;
    }
    public String getRodzaj(){
        return rodzaj;
    }
    public Date getData_waznosci(){
        return data_waznosci;
    }
    public double getWaga(){
        return waga;
    }


    public void dodaj_date(String data){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            data_waznosci = sdf1.parse(data);
        }
        catch(ParseException e){
            e.printStackTrace();
        }

    }
}
