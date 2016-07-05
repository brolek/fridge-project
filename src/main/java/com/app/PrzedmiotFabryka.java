package com.app;

/**
 * Created by Bartek on 2016-07-05.
 */
public class PrzedmiotFabryka {

    public Przedmiot stworzPrzedmiot(int numer)
    {
        Przedmiot obiekt = null;

        if(numer == 1)
        {
            return new Nabial();
        }
        else if(numer == 2)
        {
            return new Mieso();
        }
        else if(numer == 3)
        {
            return new Ryby();
        }
        else if(numer == 4)
        {
            return new Warzywa();
        }
        else if(numer == 5)
        {
            return new Ciasta();
        }
        else if(numer == 6)
        {
            return new Napoje();
        }
        else return null;
    }
}
