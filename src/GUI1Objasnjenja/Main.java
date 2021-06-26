package GUI1Objasnjenja;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc;

    public static void main(String[] args) throws SQLException {
        // Main is controll class ...
        // Prikupljamo sledece podatke od korisnika, SCANNER...
         sc = new Scanner(System.in);

        System.out.println("Odaberite opciju:");
        System.out.println("1. Registracija");
        System.out.println("2. Login");
        
        int opcija = sc.nextInt();
        
        switch(opcija){
            case 1:
                registracija();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("Nepoznata opcija.");
        }
    }
   
    // Metode za registraciju i logovanje...
    // Korisnik  unesosi usrname, logika...
    // Main metod je kreator Scanner input metode iz tog razloga static reg.
    // Ne vidi Scanner pa se on mora postaviti ispod main kontrol metode kako bi Scanner videle sve metode...
    // Main metod je kreator Skenera pa se on mora podici iznad svih metoda kako bi bila vidljiva za sve ostale...
    // Scanner je deklarisan u klasi a Main ga je samo inicijalizovao, obavezno obrisati Scanner deklar. kako ne bi imali dva objekta...
    // Scanner je bio u Main metodi. Kada smo ga postavili iznad svih metoda kao KLASNI ATRIBUT, dakle vidljiv je za celu klasu, sve metode...
    private static void registracija() throws SQLException {
        System.out.println("------REGISTRACIJA-------");
        System.out.println("Unesite username: ");
        String username = sc.next(); 
        System.out.println("Unesite password: ");
        String password = sc.next();
        // Kontrol Main metod je preuzeo podatke iz View(kod iznad) i kreira Modele koje treba prikazati korisniku(User).
        //Kreirali smo View .
        // Ako nemamo ID orisnika pozivamo konstruktor koji prima samo username i password...
        // Skupili smo podatke sa View i napravili tj. azurirali model, uneli nove podatke...
        User u = new User(username, password);
        // Sada unete podatke za registraciju treba da spustimo i sacuvamo u bazi kako bi korisnik mogao da se uloguje...
        // Kreiramo objekat User koji u konstruktoru sadrzi username,password i kreiramo metod DBqueries.insertUser(u) koji pozivamo u klasi DBQuerry
        // Kreiramo posebnu klasu za unosenje i cuvanje podataka u bazi, DBQuerries...
        
        DBqueries.insertUser(u);
    }
    private static void login() throws SQLException {
        System.out.println("-------LOGIN-------");
        System.out.println("Unesite username: ");
        String username = sc.next();
        System.out.println("Unesite password: ");
        String password = sc.next();
        User u = new User(username, password);
        // Posto regist. korisnika vec imamo moramo proveriti validnost unetih podataka(username,password) pa koristimo check
        boolean ok = DBqueries.checkUser(u);
        if(ok){
            System.out.println("Uspesno ste se ulogovali.");
        // Nastavi sa radom
        prikaziKategorije();
            
        
        }
        else
            System.out.println("Niste se ulogovali.");
        
    }

    private static void prikaziKategorije() throws SQLException {
        System.out.println("Izaberite kategoriju: ");
        // Posto ne znamo koliko podataka ima u bazi koristimo array listu...
        // Kreiramo ArrayList generic Category pod nnazivom kategorije
        // Dovlacimo kategorije iz Baze podataka DBqueries get AllCategories();
        ArrayList<Category> kategorije;
        kategorije = DBqueries.getAllCategories();
        for(Category o : kategorije)
            System.out.println(o);
        int kat = sc.nextInt();
        // Kada korisnik unese kategorije pravimo metodu koja prikazuje unetu kategoriju(kat)
        prikaziProizvodi(kat);
        
    }

    private static void prikaziProizvodi(int kat) throws SQLException  {
        // Da bi izlistali proizvode koristimo ArrayList...
        ArrayList<Item>proizvodi;
        proizvodi = DBqueries.getAllItemByCategory(kat);
        for(Item it:proizvodi)
            System.out.println(it);
        System.out.println("Izaberi item: ");
        int Item = sc.nextInt();
        System.out.println(Item);
        
    }

}
