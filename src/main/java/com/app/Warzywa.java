package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Warzywa extends Przedmiot{
    private String nazwa;
    private final String rodzaj = "warzywa";
    private Date data_waznosci;
    private double waga;
    private String kraj_pochodzenia;

    public void Warzywa(String nazwaa,Date data,double wagaa,String krajj)
    {
        nazwa=nazwaa;
        data_waznosci = data;
        waga = wagaa;
        kraj_pochodzenia = krajj;

    }
    public void setNazwa(String nazwaa)
    {
        nazwa = nazwaa;
    }

    public void setWaga(double wagaa)
    {
        waga = wagaa;
    }
    public void setUnique2(String kraj)
    {
        kraj_pochodzenia = kraj;
    }
    public void setUnique(double x){};
    public String getUnique2(){
        return kraj_pochodzenia;
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
