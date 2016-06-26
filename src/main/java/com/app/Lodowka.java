package com.app;

import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import static java.lang.System.exit;
import static java.lang.System.inheritedChannel;

/**
 * Created by Bartek on 2016-06-11.
 */
public class Lodowka {

    public static void wyswietl_baze(){
        System.out.println("W lodówce znajdują się: ");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from przedmioty");

            while(myRs.next()){
                System.out.println(myRs.getInt("id") +". " + myRs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void dokladne_dane(){
        wyswietl_baze();
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
        int id= skan.nextInt();


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            String sql = "select * from przedmioty where id=?";
            PreparedStatement myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1,id);
            //myStmt.executeUpdate();
            ResultSet Rs = myStmt.executeQuery();
            while (Rs.next()) {
                System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA");
                System.out.println(Rs.getString("nazwa")+ ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t" + Rs.getDouble("waga"));

            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static Przedmiot dodaj_dane(Przedmiot obiekt)
    {
        Scanner skan = new Scanner(System.in);
        Scanner skan2 = new Scanner(System.in);
        Scanner skan3 = new Scanner(System.in);
        System.out.println("Podaj nazwe elementu (np. banan lub dżem)");
        String nazwa = skan.nextLine();
        obiekt.setNazwa(nazwa);
        obiekt.dodaj_date();
        System.out.println("Podaj wagę przedmiotu (w kilogramach): ");
        double waga = skan.nextDouble();
        obiekt.setWaga(waga);
        //System.out.println("Podaj procent tłuszczu przedmiotu: ");
       // double tluszcz = skan.nextDouble();
        //obiekt.setdodatkowa(tluszcz);
        return obiekt;


    }
    public static void do_bazy(Przedmiot obiekt){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            String sql = "insert into przedmioty (nazwa, rodzaj,data_waznosci,waga) values ( ?, ?, ?, ?)";
            PreparedStatement myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1,obiekt.getNazwa());
            myStmt.setString(2,obiekt.getRodzaj());


            java.sql.Date sqlDate = new java.sql.Date(obiekt.getData_waznosci().getTime());
            myStmt.setDate(3,sqlDate);
            myStmt.setDouble(4,obiekt.getWaga());
            myStmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Dodano " + obiekt.getNazwa());
    }
    public static void dodaj_element(){
        Scanner skan = new Scanner(System.in);

        Scanner skan2 = new Scanner(System.in);
        Scanner skan3 = new Scanner(System.in);
        System.out.println("Podaj numer kategorii którą chcesz dodać: ");
        System.out.println("1. Nabiał");
        System.out.println("2. Mięso");
        System.out.println("3. Ryby");
        System.out.println("4. Warzywa");
        System.out.println("5. Ciasta");
        System.out.println("6. Napoje");

        int kategoria = skan2.nextInt();

        switch (kategoria)
        {
            case 1:
                Przedmiot obiekt = new Nabial();
                dodaj_dane(obiekt);
                do_bazy(obiekt);
                obiekt = null;
                break;
            case 2:
                Przedmiot obiekt2 = new Mieso();
                dodaj_dane(obiekt2);
                do_bazy(obiekt2);
                break;
            case 3:
                Przedmiot obiekt3 = new Ryby();
                dodaj_dane(obiekt3);
                do_bazy(obiekt3);
                break;
            case 4:
                Przedmiot obiekt4 = new Warzywa();
                dodaj_dane(obiekt4);
                do_bazy(obiekt4);
                break;
            case 5:
                Przedmiot obiekt5 = new Ciasta();
                dodaj_dane(obiekt5);
                do_bazy(obiekt5);
                break;
            case 6:
                Przedmiot obiekt6 = new Napoje();
                dodaj_dane(obiekt6);
                do_bazy(obiekt6);
                break;

        }



          //  String nazwa = skan2.nextLine();
           // System.out.println("Podaj rodzaj elementu (np. nabiał, mięso, warzywa");
           // String rodzaj = skan3.nextLine();
           // System.out.println("Podaj datę upłynięcia terminu ważności (rrrr-mm-dd");
            //String data = skan.nextLine();

        /*try {
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
*/




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
            int i=1;
            while(myRs.next()){
                System.out.println(i +". " + myRs.getString("nazwa"));
                i+=1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }
    public static void wyciagnij_element(){

        sprawdz_zawartosc();
        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj nazwe przedmiotu który chcesz wyciągnąć: ");
        String nazwa = skan.nextLine();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            String sql = "delete from przedmioty where nazwa=?";
            PreparedStatement myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1,nazwa);
            myStmt.executeUpdate();
            System.out.println("Usunięto " + nazwa);

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static void edytuj(){

        System.out.println("W lodówce znajdują się: ");

        wyswietl_baze();

        Scanner skan = new Scanner(System.in);
        Scanner skan2 = new Scanner(System.in);
        Scanner skan3 = new Scanner(System.in);
        Scanner skan4 = new Scanner(System.in);
        Scanner skan5 = new Scanner(System.in);
        System.out.println("Podaj id przedmiotu który chcesz edytować: ");
        int numer = skan.nextInt();
        System.out.println("Napisz jak chcesz edytować nazwę: ");
        String nazwa = skan2.nextLine();
        System.out.println("Napisz jak chcesz edytować rodzaj? ");
        String rodzaj = skan3.nextLine();
        System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
        String data = skan4.nextLine();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dataa =null;
        try {
            dataa = sdf1.parse(data);

        }
        catch(ParseException e){
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(dataa.getTime());
        System.out.println("Napisz jak chcesz edytować wagę ? ");
        double waga= skan5.nextDouble();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            String sql = "update przedmioty set nazwa=?, rodzaj= ?, data_waznosci =?, waga= ? where id=?";
            PreparedStatement myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1,nazwa);
            myStmt.setString(2,rodzaj);
            myStmt.setDate(3,sqlDate);
            myStmt.setDouble(4,waga);
            myStmt.setInt(5,numer);

            myStmt.executeUpdate();
            System.out.println("Pomyślnie edytowano element o id = " + numer);

        }
        catch (SQLException e) {
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
            System.out.println("4. Wyświetl dokładne dane podanego przedmiotu - wybierz 4.");
            System.out.println("5. Edytuj określony przedmiot - wybierz 5");
            System.out.println("6. Wyjście - wybierz 6");

            int wybor = skan.nextInt();
            switch (wybor) {
                case 1:
                    dodaj_element();
                    break;
                case 2:
                    wyciagnij_element();
                    break;
                case 3:
                    sprawdz_zawartosc();
                    break;
                case 4:
                    dokladne_dane();
                    break;
                case 5:
                    edytuj();
                    break;
                case 6:
                    exit(0);


            }
        }

    }





}
