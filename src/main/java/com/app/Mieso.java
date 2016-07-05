package com.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Bartek on 2016-06-26.
 */
public class Mieso extends Przedmiot{
    private String nazwa;
    private final String rodzaj = "mieso";
    private Date data_waznosci;
    private double waga;
    private String kraj;

    public void Mięso(String nazwaa,Date data,double wagaa,String kraj)
    {
        nazwa=nazwaa;
        data_waznosci = data;
        waga = wagaa;
        this.kraj=kraj;

    }
    public void setNazwa(String nazwaa)
    {
        nazwa = nazwaa;
    }

    public void setWaga(double wagaa)
    {
        waga = wagaa;
    }
    public void setUnique2(String krajj)
    {
        //Scanner skan = new Scanner(System.in);
        //System.out.println("Podaj kraj pochodzenia: ");
        //String krajj = skan.nextLine();
        kraj=krajj;
    }
    public void setUnique(double x){};
    public String getUnique2(){
        return kraj;
    }
    public double getUnique(){return 0;}


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
