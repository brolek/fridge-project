package com.app;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


 // Created by Bartek on 2016-06-14.

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
        //obiekt.setUnique();
        int sprawdz = Lodowka.do_bazy(obiekt);
        Assert.assertEquals(1,sprawdz);
    }

    @Test
    public void sprawdz_zawartosc(){

        int sprawdz = Lodowka.sprawdz_zawartosc();


        Assert.assertEquals(1,sprawdz);
    }



}
