package com.app;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;



import static java.lang.System.exit;



public class Lodowka {

    public static void czekaj(){
        try {
            Thread.sleep(2000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    public static String wyswietl_baze(Przedmiot obiekt){

        try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false","root","root");
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from "+obiekt.getRodzaj());

            while(myRs.next()){
                System.out.println(myRs.getInt("id") +". " + myRs.getString("nazwa"));
                obiekt.setNazwa(myRs.getString("nazwa"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obiekt.getNazwa();

    }
    public static Przedmiot zapisz_do_obiektu(int id,String wybor){
        int numer =0;
        if (wybor == "nabial")
        {
            numer = 1;
        }
        if (wybor == "mieso")
        {
            numer =2;
        }
        if (wybor =="ryby")
        {
            numer =3;
        }
        if (wybor =="warzywa")
        {
            numer =4;
        }
        if (wybor=="ciasta")
        {
            numer =5;
        }
        if (wybor=="napoje")
        {
            numer =6;
        }
        PrzedmiotFabryka nowy = new PrzedmiotFabryka();
        Przedmiot obiekt = null;
        obiekt = nowy.stworzPrzedmiot(numer);



        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            String sql = "select * from "+wybor+" where id=?";
            PreparedStatement myStmt = myConn.prepareStatement(sql);
            myStmt.setInt(1, id);
            ResultSet Rs = myStmt.executeQuery();
            while (Rs.next()) {
                obiekt.setNazwa(Rs.getString("nazwa"));
                obiekt.setRodzaj(Rs.getString("rodzaj"));
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                String text = df.format(Rs.getDate("data_waznosci"));
                obiekt.dodaj_date(text);
                obiekt.setWaga(Rs.getDouble("waga"));
                if (wybor == "nabial")
                {
                    obiekt.setUnique(Rs.getDouble("procent"));
                }
                if (wybor == "mieso")
                {
                    obiekt.setUnique2(Rs.getString("kraj"));
                }
                if (wybor =="ryby")
                {
                    obiekt.setUnique2(Rs.getString("zbiornik"));
                }
                if (wybor =="warzywa")
                {
                    obiekt.setUnique2(Rs.getString("kraj"));
                }
                if (wybor=="ciasta")
                {
                    obiekt.setUnique2(Rs.getString("firma"));
                }
                if (wybor=="napoje")
                {
                    obiekt.setUnique(Rs.getDouble("procent"));
                }

            }


        }
            catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        return obiekt;
    }

    public static void dokladne_dane(){
        while(true) {
            Scanner skan = new Scanner(System.in);
            Scanner skan2 = new Scanner(System.in);
            System.out.println("Podaj numer kategorii z której chcesz dokładniej obejrzeć przedmiot: ");
            System.out.println("1. Nabiał");
            System.out.println("2. Mięso");
            System.out.println("3. Ryby");
            System.out.println("4. Warzywa");
            System.out.println("5. Ciasta");
            System.out.println("6. Napoje");

            String wyborr = skan.nextLine();
            if ((!wyborr.equals("1") && !wyborr.equals("2") && !wyborr.equals("3") && !wyborr.equals("4") && !wyborr.equals("5") && !wyborr.equals("6"))) {
                System.out.println("Podano zły numer");
                czekaj();

            } else {

                int numer = new Integer(wyborr).intValue();
                //int numer = skan2.nextInt();
                int id = 0;
                String sql = "";

                PrzedmiotFabryka nowy = new PrzedmiotFabryka();
                Przedmiot obiekt = null;
                obiekt = nowy.stworzPrzedmiot(numer);
                wyswietl_baze(obiekt);


                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
                    if (numer == 1) {
                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                                id = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception)
                            {
                                System.out.println("Podaną zły numer, spróbuj jeszcze raz.");
                            }
                        }
                        sql = "select * from nabial where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setInt(1, id);
                        ResultSet Rs = myStmt.executeQuery();
                        while (Rs.next()) {
                            System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tPROCENT TŁUSZCZU");
                            System.out.println(Rs.getString("nazwa") + ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga") + "\t\t" + Rs.getDouble("procent"));
                            czekaj();
                        }
                    }
                    if (numer == 2) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                                id = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception)
                            {
                                System.out.println("Podaną zły numer, spróbuj jeszcze raz.");
                            }
                        }
                        sql = "select * from mieso where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setInt(1, id);
                        ResultSet Rs = myStmt.executeQuery();
                        while (Rs.next()) {
                            System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tKRAJ POCHODZENIA");
                            System.out.println(Rs.getString("nazwa") + ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga") + "\t\t" + Rs.getString("kraj"));
                            czekaj();
                        }
                    }
                    if (numer == 3) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                                id = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception)
                            {
                                System.out.println("Podaną zły numer, spróbuj jeszcze raz.");
                            }
                        }
                        sql = "select * from ryby where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setInt(1, id);
                        ResultSet Rs = myStmt.executeQuery();
                        while (Rs.next()) {
                            System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tZBIORNIK");
                            System.out.println(Rs.getString("nazwa") + ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga") + "\t" + Rs.getString("zbiornik"));
                            czekaj();
                        }
                    }
                    if (numer == 4) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                                id = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception)
                            {
                                System.out.println("Podaną zły numer, spróbuj jeszcze raz.");
                            }
                        }
                        sql = "select * from warzywa where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setInt(1, id);
                        ResultSet Rs = myStmt.executeQuery();
                        while (Rs.next()) {
                            System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tKRAJ POCHODZENIA");
                            System.out.println(Rs.getString("nazwa") + ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga") + "\t\t" + Rs.getString("kraj"));
                            czekaj();
                        }
                    }
                    if (numer == 5) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                                id = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception)
                            {
                                System.out.println("Podaną zły numer, spróbuj jeszcze raz.");
                            }
                        }
                        sql = "select * from ciasta where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setInt(1, id);
                        ResultSet Rs = myStmt.executeQuery();
                        while (Rs.next()) {
                            System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tCUKIERNIA");
                            System.out.println(Rs.getString("nazwa") + ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga") + "\t" + Rs.getString("firma"));
                            czekaj();
                        }
                    }
                    if (numer == 6) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id elementu który chcesz dokładnie obejrzeć: ");
                                id = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception)
                            {
                                System.out.println("Podaną zły numer, spróbuj jeszcze raz.");
                            }
                        }
                        sql = "select * from napoje where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setInt(1, id);
                        ResultSet Rs = myStmt.executeQuery();
                        while (Rs.next()) {
                            System.out.println("NAZWA\tRODZAJ\tDATA WAZNOSCI\tWAGA\tZAWARTOSC ALKOHOLU");
                            System.out.println(Rs.getString("nazwa") + ",\t" + Rs.getString("rodzaj") + ",\t" + Rs.getDate("data_waznosci") + ",\t\t" + Rs.getDouble("waga") + "\t\t\t" + Rs.getDouble("procent") + "%");
                            czekaj();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

    }
    public static Przedmiot dodaj_dane(Przedmiot obiekt) {
        Scanner skan = new Scanner(System.in);
        Scanner skan2 = new Scanner(System.in);
        Scanner skan3 = new Scanner(System.in);
        System.out.println("Podaj nazwe elementu (np. twaróg, banan, mleko, piwo): ");
        String nazwa = skan.nextLine();
        obiekt.setNazwa(nazwa);
        System.out.println("Podaj date ważności: ");
        String data ="";
        while (true) {
            System.out.println("Podaj date ważności: ");
            data = skan.nextLine();
            if (data.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")) {
                break;
            } else
                System.out.println("Data musi być w formacie (rrrr-mm-dd)\n");

        }

        obiekt.dodaj_date(data);
        System.out.println("Podaj wagę przedmiotu (w kilogramach): ");
        double waga = 0;
        while (true) {
            try {
                waga = Double.parseDouble(skan.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
            }
        }
        //double waga = skan.nextDouble();
        obiekt.setWaga(waga);

        if (obiekt.getRodzaj() == "nabial")
        {
            System.out.println("Podaj procent zawartości tłuszczu: ");
            double procent =0;
            while (true) {
                try {
                    procent = Double.parseDouble(skan.next());
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                }
            }
            obiekt.setUnique(procent);
        }
        if (obiekt.getRodzaj() == "mieso")
        {
            System.out.println("Podaj kraj pochodzenia: ");
            String kraj = skan2.nextLine();
            obiekt.setUnique2(kraj);
        }
        if (obiekt.getRodzaj() =="ryby")
        {
            System.out.println("Podaj zbiornik z którego pochodzi ta ryba: ");
            String zbiornik = skan2.nextLine();
            obiekt.setUnique2(zbiornik);
        }
        if (obiekt.getRodzaj() =="warzywa")
        {
            System.out.println("Podaj kraj pochodzenia: ");
            String kraj = skan2.nextLine();
            obiekt.setUnique2(kraj);
        }
        if (obiekt.getRodzaj()=="ciasta")
        {
            System.out.println("Podaj nazwę cukierni: ");
            String cukiernia = skan2.nextLine();
            obiekt.setUnique2(cukiernia);
        }
        if (obiekt.getRodzaj()=="napoje")
        {
            System.out.println("Podaj zawartośc procentową alkoholu: ");
            double procent  =0;
            while (true) {
                try {
                    procent = Double.parseDouble(skan.next());
                    break;
                } catch (NumberFormatException ignore) {
                    System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                }
            }
            obiekt.setUnique(procent);
        }

        return obiekt;


    }
    public static int do_bazy(Przedmiot obiekt){
        int powodzenie =0;
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
            powodzenie=1;
            return powodzenie;

        }
        catch (SQLException e) {
            e.printStackTrace();

            return powodzenie;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return powodzenie;
        }

    }
    public static void dodaj_element(){
        while(true) {

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
            String wyborr = skan.nextLine();
            if ((!wyborr.equals("1") && !wyborr.equals("2") && !wyborr.equals("3") && !wyborr.equals("4") && !wyborr.equals("5") && !wyborr.equals("6"))) {
                System.out.println("Podano zły numer");
                czekaj();

            } else {

                int kategoria = new Integer(wyborr).intValue();


                switch (kategoria) {
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
                break;
            }
        }

    }

    public static int sprawdz_zawartosc()
    {
        System.out.println("---W lodówce znajdują się: ");
        int sprawdz=0;
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

            czekaj();
            sprawdz =1;
            return sprawdz;
        } catch (SQLException e) {
            e.printStackTrace();
            return sprawdz;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        return sprawdz;
    }

    public static Przedmiot usun(int id,String wybor,int kategoria,Originator o,Caretaker c)
    {
        PrzedmiotFabryka nowy = new PrzedmiotFabryka();
        Przedmiot obiekt = null;
        obiekt = nowy.stworzPrzedmiot(kategoria);
        String sql="";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
            obiekt = zapisz_do_obiektu(id,wybor);
            o.setNazwa(obiekt.getNazwa());
            o.setRodzaj(obiekt.getRodzaj());
            o.setData(obiekt.getData_waznosci());
            o.setWaga(obiekt.getWaga());
            c.dodajMemento(o.zapisz());
            sql = "delete from "+wybor+" where id=?";
            PreparedStatement myStmt = myConn.prepareStatement(sql);

            myStmt.setInt(1,id);
            myStmt.executeUpdate();
            //System.out.println("Usunięto element o id " + id);
            obiekt = null;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obiekt;

    }

    public static void wyciagnij_element(){
        while(true) {
            Caretaker caretaker = new Caretaker();
            Originator originator = new Originator();
            Scanner skan = new Scanner(System.in);
            Scanner skan2 = new Scanner(System.in);
            System.out.println("Podaj półkę z której chcesz wyciągnąć przedmiot: ");
            System.out.println("1. Nabiał");
            System.out.println("2. Mięso");
            System.out.println("3. Ryby");
            System.out.println("4. Warzywa");
            System.out.println("5. Ciasta");
            System.out.println("6. Napoje");

            String wyborr = skan.nextLine();
            if ((!wyborr.equals("1") && !wyborr.equals("2") && !wyborr.equals("3") && !wyborr.equals("4") && !wyborr.equals("5") && !wyborr.equals("6"))) {
                System.out.println("Podano zły numer");
                czekaj();

            } else {

                int kategoria = new Integer(wyborr).intValue();

                String wybor = "";
                //int kategoria = skan2.nextInt();
                if (kategoria == 1) {
                    wybor = "nabial";
                }
                if (kategoria == 2) {
                    wybor = "mieso";
                }
                if (kategoria == 3) {
                    wybor = "ryby";
                }
                if (kategoria == 4) {
                    wybor = "warzywa";
                }
                if (kategoria == 5) {
                    wybor = "ciasta";
                }
                if (kategoria == 6) {
                    wybor = "napoje";
                }

                PrzedmiotFabryka nowy = new PrzedmiotFabryka();
                Przedmiot obiekt = null;
                obiekt = nowy.stworzPrzedmiot(kategoria);
                wyswietl_baze(obiekt);
                int idd =0;
                while(true) {

                    try {
                        Scanner skan3=new Scanner(System.in);
                        System.out.println("Podaj id elementu który chcesz wyciągnąć: ");
                        idd = skan3.nextInt();

                        break;
                    }catch(InputMismatchException exception)
                    {
                        System.out.println("Podano złą wartość. Spróbuj jeszcze raz.");
                    }
                }
                //Scanner skann = new Scanner(System.in) ;
                usun(idd, wybor, kategoria, originator, caretaker);
                System.out.println("Usunąłeś " + originator.odczytaj(caretaker.odczytaj(0)));
                break;
            }

        }

    }
    public static int dodaj(int a,int b)
    {
        return a+b;
    }

    public static int edytuj(){
        int sprawdz =0;
        //System.out.println("W lodówce znajdują się: ");

        while(true) {

            Scanner skan = new Scanner(System.in);
            System.out.println("Podaj półkę z której chcesz edytować przedmiot: ");
            System.out.println("1. Nabiał");
            System.out.println("2. Mięso");
            System.out.println("3. Ryby");
            System.out.println("4. Warzywa");
            System.out.println("5. Ciasta");
            System.out.println("6. Napoje");

            String wyborr = skan.nextLine();
            if ((!wyborr.equals("1") && !wyborr.equals("2") && !wyborr.equals("3") && !wyborr.equals("4") && !wyborr.equals("5") && !wyborr.equals("6"))) {
                System.out.println("Podano zły numer");
                czekaj();

            } else {

                int kategoria = new Integer(wyborr).intValue();
                //int kategoria = skan.nextInt();


                Scanner skan2 = new Scanner(System.in);
                Scanner skan3 = new Scanner(System.in);
                Scanner skan4 = new Scanner(System.in);
                Scanner skan5 = new Scanner(System.in);
                Scanner skan6 = new Scanner(System.in);

                //System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                int numer = 0;

                PrzedmiotFabryka nowy = new PrzedmiotFabryka();
                Przedmiot obiekt = null;
                obiekt = nowy.stworzPrzedmiot(kategoria);
                wyswietl_baze(obiekt);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lodowka?useSSL=false", "root", "root");
                    String sql = "";
                    if (kategoria == 1) {
                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                                numer = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception) {
                                System.out.println("Złe dane, spróbuj jeszcze raz.");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować nazwę: ");
                        String nazwa = skan3.nextLine();
                        //System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                        String data = "";
                        while (true) {
                            System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                            data = skan4.nextLine();
                            if (data.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")) {
                                break;
                            } else
                                System.out.println("Data musi być w formacie (rrrr-mm-dd)\n");

                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date dataa = null;
                        try {
                            dataa = sdf1.parse(data);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        java.sql.Date sqlDate = new java.sql.Date(dataa.getTime());
                        System.out.println("Napisz jak chcesz edytować wagę ? ");
                        double waga = 0;

                        while (true) {
                            try {
                                waga = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }


                        System.out.println("Napisz jak chcesz edytować procent zawartości tłuszczu ? ");
                        double tluszcz = 0;

                        while (true) {
                            try {
                                tluszcz = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }
                        sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, procent =? where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setString(1, nazwa);
                        myStmt.setDate(2, sqlDate);
                        myStmt.setDouble(3, waga);
                        myStmt.setDouble(4, tluszcz);
                        myStmt.setInt(5, numer);
                        myStmt.executeUpdate();
                    }
                    if (kategoria == 2) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                                numer = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception) {
                                System.out.println("Złe dane, spróbuj jeszcze raz.");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować nazwę: ");
                        String nazwa = skan3.nextLine();
                        //System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                        String data = "";
                        while (true) {
                            System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                            data = skan4.nextLine();
                            if (data.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")) {
                                break;
                            } else
                                System.out.println("Data musi być w formacie (rrrr-mm-dd)\n");

                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date dataa = null;
                        try {
                            dataa = sdf1.parse(data);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        java.sql.Date sqlDate = new java.sql.Date(dataa.getTime());
                        System.out.println("Napisz jak chcesz edytować wagę ? ");
                        double waga = 0;

                        while (true) {
                            try {
                                waga = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować kraj pochodzenia ? ");
                        String kraj = skan6.nextLine();
                        sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, kraj =? where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setString(1, nazwa);
                        myStmt.setDate(2, sqlDate);
                        myStmt.setDouble(3, waga);
                        myStmt.setString(4, kraj);
                        myStmt.setInt(5, numer);
                        myStmt.executeUpdate();
                    }
                    if (kategoria == 3) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                                numer = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception) {
                                System.out.println("Złe dane, spróbuj jeszcze raz.");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować nazwę: ");
                        String nazwa = skan3.nextLine();
                        //System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                        String data = "";
                        while (true) {
                            System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                            data = skan4.nextLine();
                            if (data.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")) {
                                break;
                            } else
                                System.out.println("Data musi być w formacie (rrrr-mm-dd)\n");

                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date dataa = null;
                        try {
                            dataa = sdf1.parse(data);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        java.sql.Date sqlDate = new java.sql.Date(dataa.getTime());
                        System.out.println("Napisz jak chcesz edytować wagę ? ");
                        double waga = 0;

                        while (true) {
                            try {
                                waga = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować zbiornik z którego pochodzi ta ryba ? ");
                        String zbiornik = skan6.nextLine();
                        sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, zbiornik =? where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setString(1, nazwa);
                        myStmt.setDate(2, sqlDate);
                        myStmt.setDouble(3, waga);
                        myStmt.setString(4, zbiornik);
                        myStmt.setInt(5, numer);
                        myStmt.executeUpdate();
                    }
                    if (kategoria == 4) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                                numer = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception) {
                                System.out.println("Złe dane, spróbuj jeszcze raz.");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować nazwę: ");
                        String nazwa = skan3.nextLine();
                        //System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                        String data = "";
                        while (true) {
                            System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                            data = skan4.nextLine();
                            if (data.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")) {
                                break;
                            } else
                                System.out.println("Data musi być w formacie (rrrr-mm-dd)\n");

                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date dataa = null;
                        try {
                            dataa = sdf1.parse(data);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        java.sql.Date sqlDate = new java.sql.Date(dataa.getTime());
                        System.out.println("Napisz jak chcesz edytować wagę ? ");
                        double waga = 0;

                        while (true) {
                            try {
                                waga = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować kraj pochodzenia ? ");
                        String kraj = skan6.nextLine();
                        sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, kraj =? where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setString(1, nazwa);
                        myStmt.setDate(2, sqlDate);
                        myStmt.setDouble(3, waga);
                        myStmt.setString(4, kraj);
                        myStmt.setInt(5, numer);
                        myStmt.executeUpdate();
                    }
                    if (kategoria == 5) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                                numer = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception) {
                                System.out.println("Złe dane, spróbuj jeszcze raz.");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować nazwę: ");
                        String nazwa = skan3.nextLine();
                        //System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                        String data = "";
                        while (true) {
                            System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                            data = skan4.nextLine();
                            if (data.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")) {
                                break;
                            } else
                                System.out.println("Data musi być w formacie (rrrr-mm-dd)\n");

                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date dataa = null;
                        try {
                            dataa = sdf1.parse(data);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        java.sql.Date sqlDate = new java.sql.Date(dataa.getTime());
                        System.out.println("Napisz jak chcesz edytować wagę ? ");
                        double waga = 0;

                        while (true) {
                            try {
                                waga = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować nazwę firmy ? ");
                        String firma = skan6.nextLine();
                        sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, firma =? where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setString(1, nazwa);
                        myStmt.setDate(2, sqlDate);
                        myStmt.setDouble(3, waga);
                        myStmt.setString(4, firma);
                        myStmt.setInt(5, numer);
                        myStmt.executeUpdate();
                    }
                    if (kategoria == 6) {

                        while(true) {
                            try {
                                Scanner skan7=new Scanner(System.in);
                                System.out.println("Podaj id przedmiotu który chcesz edytować: ");
                                numer = skan7.nextInt();
                                break;
                            }catch(InputMismatchException exception) {
                                System.out.println("Złe dane, spróbuj jeszcze raz.");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować nazwę: ");
                        String nazwa = skan3.nextLine();
                        //System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                        String data = "";
                        while (true) {
                            System.out.println("Napisz jak chcesz edytować date(yyyy-MM-dd) ? ");
                            data = skan4.nextLine();
                            if (data.matches("[0-9]{4}[-][0-9]{2}[-][0-9]{2}")) {
                                break;
                            } else
                                System.out.println("Data musi być w formacie (rrrr-mm-dd)\n");

                        }

                        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                        java.util.Date dataa = null;
                        try {
                            dataa = sdf1.parse(data);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        java.sql.Date sqlDate = new java.sql.Date(dataa.getTime());
                        System.out.println("Napisz jak chcesz edytować wagę ? ");
                        double waga = 0;

                        while (true) {
                            try {
                                waga = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }
                        System.out.println("Napisz jak chcesz edytować procent zawartości alkoholu ? ");
                        double alkohol =0;
                       // System.out.println("Napisz jak chcesz edytować procent zawartości tłuszczu ? ");
                        //double tluszcz = 0;

                        while (true) {
                            try {
                                alkohol = Double.parseDouble(skan.next());
                                break;
                            } catch (NumberFormatException ignore) {
                                System.out.println("Wprowadzona wartość nie jest poprawna, wpisz jeszcze raz: ");
                            }
                        }


                        sql = "update nabial set nazwa=?, data_waznosci =?, waga= ?, procent =? where id=?";
                        PreparedStatement myStmt = myConn.prepareStatement(sql);
                        myStmt.setString(1, nazwa);
                        myStmt.setDate(2, sqlDate);
                        myStmt.setDouble(3, waga);
                        myStmt.setDouble(4, alkohol);
                        myStmt.setInt(5, numer);
                        myStmt.executeUpdate();
                    }

                    System.out.println("Pomyślnie edytowano element o id = " + numer);
                    sprawdz = 1;
                    czekaj();

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                return sprawdz;


            }

        }
    }



    public static void menu(){
        while(true) {
            Scanner skan = new Scanner(System.in);
            Light swiatlo = Light.getInstance();
            if(swiatlo.getSwitch()== true)
            {
                System.out.println("Swiatło zostało zaświecone");
            }
            while(true) {
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
                    czekaj();

                }
                else {

            int wybor = new Integer(wyborr).intValue();
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
                    System.out.println("---Trwa zamykanie drzwi lodówki---");
                    czekaj();
                    exit(0);
            }
            }
            }
        }

    }





}
