package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Bartek on 2016-06-26.
 */
public class Nabial extends Przedmiot {
    private String nazwa;
    private final String rodzaj = "nabial";
    private Date data_waznosci;
    private double waga;
    private double procent_tluszczu;

    public void Nabial(String nazwaa,double wagaa,double tluszcz)
    {
        nazwa=nazwaa;
       // data_waznosci = data;
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
    public void setUnique2(String x){};
    public void setUnique(double procent)
    {
       // Scanner skan = new Scanner(System.in);
        //System.out.println("Podaj zawartosc procentową tłuszczu: ");
        //double procent = skan.nextDouble();
        procent_tluszczu =procent;
    }


    public double getUnique(){
        return procent_tluszczu;
    }
    public String getUnique2(){return "";}
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


    public void dodaj_date(String data){
        //Scanner skan = new Scanner(System.in);
        //System.out.println("Podaj date upłynięcia terminu ważności produktu ('rrrr-mm-dd'): ");
        //String data = skan.nextLine();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            data_waznosci = sdf1.parse(data);
        }
        catch(ParseException e){
            e.printStackTrace();
        }

    }

}
