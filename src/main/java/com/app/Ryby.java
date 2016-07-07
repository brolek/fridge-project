package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ryby extends Przedmiot{
    private String nazwa;
    private final String rodzaj = "ryby";
    private Date data_waznosci;
    private double waga;
    private String zbiornik;

    public void Ryby(String nazwaa,Date data,double wagaa,String zbiornikk)
    {
        nazwa=nazwaa;
        data_waznosci = data;
        waga = wagaa;
        zbiornik=zbiornikk;

    }
    public void setNazwa(String nazwaa)
    {
        nazwa = nazwaa;
    }

    public void setWaga(double wagaa)
    {
        waga = wagaa;
    }
    public void setUnique2(String zbiornikk)
    {
        zbiornik=zbiornikk;
    }
    public void setUnique(double x){};
    public String getUnique2(){
        return zbiornik;
    }
    public double getUnique(){return 0;}

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
