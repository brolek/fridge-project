package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Bartek on 2016-06-26.
 */
public class Nabial extends Przedmiot {
    private String nazwa;
    private final String rodzaj = "nabiał";
    private Date data_waznosci;
    private double waga;
    private double procent_tluszczu;

    public void Nabial(String nazwaa,Date data,double wagaa,double tluszcz)
    {
        nazwa=nazwaa;
        data_waznosci = data;
        waga = wagaa;
        procent_tluszczu = tluszcz;
    }
    public void setNazwa(String nazwaa)
    {
        nazwa = nazwaa;
    }

    public void setWaga(double wagaa)
    {
        waga = wagaa;
    }
    public void setdodatkowa(double x)
    {
        procent_tluszczu =x;
    }

    public void wyswietl(){

    }
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
    public double getdodatkowa(){
        return procent_tluszczu;
    }

    public void dodaj_date(){
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj date upłynięcia terminu ważności produktu ('rrrr-mm-dd'): ");
        String data = skan.nextLine();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date data_waznosci = sdf1.parse(data);
        }
        catch(ParseException e){
            e.printStackTrace();
        }

    }

}
