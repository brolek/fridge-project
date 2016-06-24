package com.app;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.clearProperty;
import static java.lang.System.exit;

/**
 * Created by Bartek on 2016-06-11.
 */
public class Lodowka {

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }


    public static void dodaj_element(){
        System.out.println("Ile elementów chcesz dodać?");
        Scanner skan = new Scanner(System.in);
        Scanner skan2 = new Scanner(System.in);
        Scanner skan3 = new Scanner(System.in);
        int ilosc = skan.nextInt();
        for(int i =0 ;i <ilosc ; i++){
            System.out.println("Podaj nazwe elementu (np. banan lub dżem");
            String nazwa = skan2.nextLine();
            System.out.println("Podaj rodzaj elementu (np. nabiał, mięso, warzywa");
            String rodzaj = skan3.nextLine();
           // System.out.println("Podaj datę upłynięcia terminu ważności (rrrr-mm-dd");
            //String data = skan.nextLine();

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
                String sql = "insert into przedmioty (nazwa, rodzaj) values ( ?, ? )";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1,nazwa);
                myStmt.setString(2,rodzaj);
                myStmt.executeUpdate();

            }
            catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("Dodano " + nazwa);
            clearConsole();
        }



    }
    public static void sprawdz_zawartosc()
    {
        System.out.println("W lodówce znajdują się: ");
        try{
            // Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from przedmioty");
            while(myRs.next()){
                System.out.println(myRs.getString("nazwa") + ", " + myRs.getString("rodzaj"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static void menu(){
        while(true) {
            Scanner skan = new Scanner(System.in);
            System.out.println("Witaj w lodówce. Co chcesz zrobić?");
            System.out.println("1. Włóż przedmioty do lodówki - wybierz 1");
            System.out.println("2. Wyciągnij przedmioty z lodówki - wybierz 2");
            System.out.println("3. Sprawdź co znajduje się w lodówce - wybierz 3.");
            System.out.println("4. Edytuj określony przedmiot - wybierz 4");
            System.out.println("5. Wyjście - wybierz 5");

            int wybor = skan.nextInt();
            switch (wybor) {
                case 1:
                    dodaj_element();
                    break;
                case 2:

                    break;
                case 3:
                    sprawdz_zawartosc();
                    break;
                case 4:
                    exit(0);
                case 5:
                    exit(0);


            }
        }

    }





}
