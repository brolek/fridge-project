package com.app;

public class Light {
    private static Light instance = null;
    private static boolean sswitch;
    private Light(){

    }

    public static Light getInstance(){
        if(instance == null)
        {
            instance = new Light();
            sswitch = true;
            return instance;
        }
        System.out.println("Swiatło już się świeci!");
        return instance;
    }
    public boolean getSwitch(){
        return sswitch;
    }

}
