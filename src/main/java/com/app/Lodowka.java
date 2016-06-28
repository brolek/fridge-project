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


    public static void wyswietl_nabial(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from nabial");

            while(myRs.next()){
                System.out.println(myRs.getInt("id") +". " + myRs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void wyswietl_ciasta(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ciasta");

            while(myRs.next()){
                System.out.println(myRs.getInt("id") +". " + myRs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void wyswietl_mieso(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from mieso");

            while(myRs.next()){
                System.out.println(myRs.getInt("id") +". " + myRs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void wyswietl_napoje(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from napoje");

            while(myRs.next()){
                System.out.println(myRs.getInt("id") +". " + myRs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void wyswietl_ryby(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ryby");

            while(myRs.next()){
                System.out.println(myRs.getInt("id") +". " + myRs.getString("nazwa"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void wyswietl_warzywa(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from warzywa");

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

        Scanner skan = new Scanner(System.in);
        Scanner skan2 = new Scanner(System.in);
        System.out.println("Podaj numer kategorii z której chcesz dokładniej obejrzeć przedmiot: ");
        System.out.println("1. Nabiał");
        System.out.println("2. Mięso");
        System.out.println("3. Ryby");
        System.out.println("4. Warzywa");
        System.out.println("5. Ciasta");
        System.out.println("6. Napoje");
        int numer = skan2.nextInt();
        int id= 0;
        String sql ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            if(numer==1) {
                wyswietl_nabial();
                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                id = skan.nextInt();
                sql = "select * from nabial where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setInt(1,id);
                ResultSet Rs = myStmt.executeQuery();
                while (Rs.next()) {
                    System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tPROCENT TŁUSZCZU");
                    System.out.println(Rs.getString("nazwa")+ ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga")+ "\t\t" + Rs.getDouble("procent"));
                }
            }
            if(numer==2) {
                wyswietl_mieso();
                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                id = skan.nextInt();
                sql = "select * from mieso where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setInt(1,id);
                ResultSet Rs = myStmt.executeQuery();
                while (Rs.next()) {
                    System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tKRAJ POCHODZENIA");
                    System.out.println(Rs.getString("nazwa")+ ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga")+ "\t\t" + Rs.getString("kraj"));
                }
            }
            if(numer==3) {
                wyswietl_ryby();
                System.out.println("Podaj id elementu który chcesz dokladnie obejrzec: ");
                id = skan.nextInt();
                sql = "select * from ryby where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setInt(1,id);
                ResultSet Rs = myStmt.executeQuery();
                while (Rs.next()) {
                    System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tZBIORNIK");
                    System.out.println(Rs.getString("nazwa")+ ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga")+ "\t"+ Rs.getString("zbiornik"));
                }
            }
            if(numer==4) {
                wyswietl_warzywa();
                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                id = skan.nextInt();
                sql = "select * from warzywa where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setInt(1,id);
                ResultSet Rs = myStmt.executeQuery();
                while (Rs.next()) {
                    System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tKRAJ POCHODZENIA");
                    System.out.println(Rs.getString("nazwa")+ ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga")+ "\t\t" + Rs.getString("kraj"));
                }
            }
            if(numer==5) {
                wyswietl_ciasta();
                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                id = skan.nextInt();
                sql = "select * from ciasta where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setInt(1,id);
                ResultSet Rs = myStmt.executeQuery();
                while (Rs.next()) {
                    System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tCUKIERNIA");
                    System.out.println(Rs.getString("nazwa")+ ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga")+ "\t"+Rs.getString("firma"));
                }
            }
            if(numer==6) {
                wyswietl_napoje();
                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                id = skan.nextInt();
                sql = "select * from napoje where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setInt(1,id);
                ResultSet Rs = myStmt.executeQuery();
                while (Rs.next()) {
                    System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tZAWARTOSC ALKOHOLU");
                    System.out.println(Rs.getString("nazwa")+ ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga")+ "\t\t\t" + Rs.getDouble("procent")+ "%");
                }
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
        obiekt.setUnique();
        return obiekt;


    }
    public static void do_bazy(Przedmiot obiekt){
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            String sql ="";
            if(obiekt.getRodzaj()=="ciasta") {
                sql = "insert into ciasta (nazwa, rodzaj,data_waznosci,waga,firma) values ( ?, ?, ?, ?, ?)";
            }
            if(obiekt.getRodzaj()=="mieso") {
                sql = "insert into mieso (nazwa, rodzaj,data_waznosci,waga,kraj) values ( ?, ?, ?, ?, ?)";
            }
            if(obiekt.getRodzaj()=="nabial") {
                sql = "insert into nabial (nazwa, rodzaj,data_waznosci,waga,procent) values ( ?, ?, ?, ?, ?)";
            }
            if(obiekt.getRodzaj()=="napoje") {
                sql = "insert into napoje (nazwa, rodzaj,data_waznosci,waga,procent) values ( ?, ?, ?, ?, ?)";
            }
            if(obiekt.getRodzaj()=="ryby") {
                sql = "insert into ryby (nazwa, rodzaj,data_waznosci,waga,zbiornik) values ( ?, ?, ?, ?, ?)";
            }
            if(obiekt.getRodzaj()=="warzywa") {
                sql = "insert into warzywa (nazwa, rodzaj,data_waznosci,waga,kraj) values ( ?, ?, ?, ?, ?)";
            }

            PreparedStatement myStmt = myConn.prepareStatement(sql);


            myStmt.setString(1,obiekt.getNazwa());
            myStmt.setString(2,obiekt.getRodzaj());


            java.sql.Date sqlDate = new java.sql.Date(obiekt.getData_waznosci().getTime());
            myStmt.setDate(3,sqlDate);
            myStmt.setDouble(4,obiekt.getWaga());
            if(obiekt.getRodzaj()=="napoje" || obiekt.getRodzaj()=="nabial")
                myStmt.setDouble(5,obiekt.getUnique());
            else
                myStmt.setString(5,obiekt.getUnique2());
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

    }

    public static void sprawdz_zawartosc()
    {
        System.out.println("W lodówce znajdują się: ");

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from ciasta");
            int i=1;
            System.out.println("--CIASTA--");
            while(myRs.next()){
                System.out.println(i +". " + myRs.getString("nazwa"));
                i+=1;
            }
            myRs = myStmt.executeQuery("select * from mieso");
            i=1;
            System.out.println("--MIĘSO--");
            while(myRs.next()){
                System.out.println(i +". " + myRs.getString("nazwa"));
                i+=1;
            }
             myRs = myStmt.executeQuery("select * from nabial");
            i=1;
            System.out.println("--NABIAŁ--");
            while(myRs.next()){
                System.out.println(i +". " + myRs.getString("nazwa"));
                i+=1;
            }
             myRs = myStmt.executeQuery("select * from napoje");
            i=1;
            System.out.println("--NAPOJE--");
            while(myRs.next()){
                System.out.println(i +". " + myRs.getString("nazwa"));
                i+=1;
            }
             myRs = myStmt.executeQuery("select * from ryby");
            i=1;
            System.out.println("--RYBY--");
            while(myRs.next()){
                System.out.println(i +". " + myRs.getString("nazwa"));
                i+=1;
            }
            myRs = myStmt.executeQuery("select * from warzywa");
            i=1;
            System.out.println("--WARZYWA--");
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

        Scanner skan = new Scanner(System.in);
        Scanner skan2 = new Scanner(System.in);
        System.out.println("Podaj półkę z której chcesz wyciągnąć przedmiot: ");
        System.out.println("1. Nabiał");
        System.out.println("2. Mięso");
        System.out.println("3. Ryby");
        System.out.println("4. Warzywa");
        System.out.println("5. Ciasta");
        System.out.println("6. Napoje");

        int kategoria = skan2.nextInt();
        System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
        int idd = 0;
        String sql ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            if(kategoria==1) {
                wyswietl_nabial();
                System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
                idd = skan.nextInt();
                sql = "delete from nabial where id=?";
            }
            if(kategoria==2) {
                wyswietl_mieso();
                System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
                idd = skan.nextInt();
                sql = "delete from mieso where id=?";
            }
            if(kategoria==3) {
                wyswietl_ryby();
                System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
                idd = skan.nextInt();
                sql = "delete from ryby where id=?";
            }
            if(kategoria==4) {
                wyswietl_warzywa();
                System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
                idd = skan.nextInt();
                sql = "delete from warzywa where id=?";
            }
            if(kategoria==5) {
                wyswietl_ciasta();
                System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
                idd = skan.nextInt();
                sql = "delete from ciasta where id=?";
            }
            if(kategoria==6) {
                wyswietl_napoje();
                System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
                idd = skan.nextInt();
                sql = "delete from napoje where id=?";
            }
            PreparedStatement myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1,idd);
            myStmt.executeUpdate();
            System.out.println("Usunięto element o id " + idd);

        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static void edytuj(){

        System.out.println("W lodówce znajdują się: ");



        Scanner skan = new Scanner(System.in);
        System.out.println("Podaj półkę z której chcesz edytować przedmiot: ");
        System.out.println("1. Nabiał");
        System.out.println("2. Mięso");
        System.out.println("3. Ryby");
        System.out.println("4. Warzywa");
        System.out.println("5. Ciasta");
        System.out.println("6. Napoje");
        int kategoria = skan.nextInt();


        Scanner skan2 = new Scanner(System.in);
        Scanner skan3 = new Scanner(System.in);
        Scanner skan4 = new Scanner(System.in);
        Scanner skan5 = new Scanner(System.in);
        Scanner skan6 = new Scanner(System.in);
        System.out.println("Podaj id przedmiotu który chcesz edytować: ");
        int numer = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            String sql ="";
            if(kategoria==1) {
                wyswietl_nabial();
                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                numer = skan2.nextInt();
                System.out.println("Napisz jak chcesz edytować nazwę: ");
                String nazwa = skan3.nextLine();
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
                System.out.println("Napisz jak chcesz edytować procent zawartości tłuszczu ? ");
                double tluszcz= skan6.nextDouble();
                sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, procent =? where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1,nazwa);
                myStmt.setDate(2,sqlDate);
                myStmt.setDouble(3,waga);
                myStmt.setDouble(4,tluszcz);
                myStmt.setInt(5,numer);
                myStmt.executeUpdate();
            }
            if(kategoria==2) {
                wyswietl_mieso();
                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                numer = skan2.nextInt();
                System.out.println("Napisz jak chcesz edytować nazwę: ");
                String nazwa = skan3.nextLine();
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
                System.out.println("Napisz jak chcesz edytować kraj pochodzenia ? ");
                String kraj= skan6.nextLine();
                sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, kraj =? where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1,nazwa);
                myStmt.setDate(2,sqlDate);
                myStmt.setDouble(3,waga);
                myStmt.setString(4,kraj);
                myStmt.setInt(5,numer);
                myStmt.executeUpdate();
            }
            if(kategoria==3) {
                wyswietl_ryby();
                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                numer = skan2.nextInt();
                System.out.println("Napisz jak chcesz edytować nazwę: ");
                String nazwa = skan3.nextLine();
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
                System.out.println("Napisz jak chcesz edytować zbiornik z którego pochodzi ta ryba ? ");
                String zbiornik= skan6.nextLine();
                sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, zbiornik =? where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1,nazwa);
                myStmt.setDate(2,sqlDate);
                myStmt.setDouble(3,waga);
                myStmt.setString(4,zbiornik);
                myStmt.setInt(5,numer);
                myStmt.executeUpdate();
            }
            if(kategoria==4) {
                wyswietl_warzywa();
                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                numer = skan2.nextInt();
                System.out.println("Napisz jak chcesz edytować nazwę: ");
                String nazwa = skan3.nextLine();
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
                System.out.println("Napisz jak chcesz edytować kraj pochodzenia ? ");
                String kraj= skan6.nextLine();
                sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, kraj =? where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1,nazwa);
                myStmt.setDate(2,sqlDate);
                myStmt.setDouble(3,waga);
                myStmt.setString(4,kraj);
                myStmt.setInt(5,numer);
                myStmt.executeUpdate();
            }
            if(kategoria==5) {
                wyswietl_ciasta();
                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                numer = skan2.nextInt();
                System.out.println("Napisz jak chcesz edytować nazwę: ");
                String nazwa = skan3.nextLine();
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
                System.out.println("Napisz jak chcesz edytować nazwę firmy ? ");
                String firma= skan6.nextLine();
                sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, firma =? where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1,nazwa);
                myStmt.setDate(2,sqlDate);
                myStmt.setDouble(3,waga);
                myStmt.setString(4,firma);
                myStmt.setInt(5,numer);
                myStmt.executeUpdate();
            }
            if(kategoria==6) {
                wyswietl_napoje();
                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                numer = skan2.nextInt();
                System.out.println("Napisz jak chcesz edytować nazwę: ");
                String nazwa = skan3.nextLine();
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
                System.out.println("Napisz jak chcesz edytować procent zawartości alkoholu ? ");
                double alkohol= skan6.nextDouble();
                sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, procent =? where id=?";
                PreparedStatement myStmt = myConn.prepareStatement(sql);
                myStmt.setString(1,nazwa);
                myStmt.setDate(2,sqlDate);
                myStmt.setDouble(3,waga);
                myStmt.setDouble(4,alkohol);
                myStmt.setInt(5,numer);
                myStmt.executeUpdate();
            }



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
