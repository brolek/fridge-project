package com.app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LodowkaTest {

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){

    }

    @Test
    public void do_bazy(){
        Przedmiot obiekt = new Nabial();

        obiekt.setNazwa("mleko");
        obiekt.dodaj_date("2016-09-08");

        obiekt.setWaga(1.5);
        int sprawdz = LodowkaController.do_bazy(obiekt);
        Assert.assertEquals(1,sprawdz);
    }


    @Test
    public void sprawdz_zawartosc(){

        int sprawdz = LodowkaController.sprawdz_zawartosc();
        Assert.assertEquals(1,sprawdz);
    }

    @Test
    public void wyswietl_baze(){
        Przedmiot obiekt =new Nabial();


        String sprawdz = LodowkaController.wyswietl_baze(obiekt);
        Assert.assertNotEquals(null,sprawdz);
    }
    @Test
    public void usun(){
        int i=1;
        String a="nabial";
        int k =1;
        Originator o = new Originator();
        Caretaker c = new Caretaker();
        Przedmiot sprawdz = LodowkaController.usun(i,a,k,o,c);
        Assert.assertEquals(null,sprawdz);
    }
    @Test
    public void dodaj(){
        int a =5;
        int b=2;
        int sprawdz = LodowkaController.dodaj(a,b);
        Assert.assertEquals(a+b,sprawdz);
    }


}
