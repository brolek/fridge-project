package com.app;

import java.util.Scanner;

import static java.lang.System.exit;

public class MenuWidok {

    public static void menu() {
        while (true) {
            Scanner skan = new Scanner(System.in);
            Light swiatlo = Light.getInstance();
            if (swiatlo.getSwitch() == true) {
                System.out.println("Swiatło zostało zaświecone");
            }


            while (true) {
                System.out.println("---Witaj w lodówce. Co chcesz zrobić?---");
                System.out.println("1. Włóż przedmioty do lodówki - wybierz 1");
                System.out.println("2. Wyciągnij przedmioty z lodówki - wybierz 2");
                System.out.println("3. Sprawdź co znajduje się w lodówce - wybierz 3.");
                System.out.println("4. Wyświetl dokładne dane podanego przedmiotu - wybierz 4.");
                System.out.println("5. Edytuj określony przedmiot - wybierz 5");
                System.out.println("6. Wyjście - wybierz 6");

                String wyborr = skan.nextLine();
                if ((!wyborr.equals("1") && !wyborr.equals("2") && !wyborr.equals("3") && !wyborr.equals("4") && !wyborr.equals("5") && !wyborr.equals("6"))) {
                    System.out.println("Podano zły numer");
                    LodowkaController.czekaj();

                } else {

                    int wybor = new Integer(wyborr).intValue();
                    switch (wybor) {
                        case 1:
                            LodowkaController.dodaj_element();
                            break;
                        case 2:
                            LodowkaController.wyciagnij_element();
                            break;
                        case 3:
                            LodowkaController.sprawdz_zawartosc();
                            break;
                        case 4:
                            LodowkaController.dokladne_dane();
                            break;
                        case 5:
                            LodowkaController.edytuj();
                            break;
                        case 6:
                            System.out.println("---Trwa zamykanie drzwi lodówki---");
                            LodowkaController.czekaj();
                            exit(0);
                    }
                }
            }
        }
    }
}
