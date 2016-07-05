package com.app;

import java.util.ArrayList;

/**
 * Created by Bartek on 2016-07-05.
 */
public class Caretaker {
    private ArrayList<Memento> lista = new ArrayList<Memento>();
    public void dodajMemento(Memento obiekt){
        lista.add(obiekt);
    }
    public Memento odczytaj(int i)
    {
        return lista.get(i);
    }

}
