package GUI1Objasnjenja;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBqueries {

    // Metoda za unosenje korisnika u bazu podataka, samo jedna, nezavisna od ostalih klasa, objekata...
    // Metoda prima Objekat User, a nakon toga metoda mora da se konektuje sa bazom kako bi unela korisnika//
    // Konektuj se na bazu koja je jednaa DBConnection getConn koji preuzimamo iz napravljene DBConnection...
    // Moramo napraviti upit kako bi uneli korisnika u bazu podataka AliExpress.
    // Prepeared Statment: Pripremamo izjavu, upit za izvrsavanje odnosno unosenje u bazu.
    // Nakon toga azuriramo upit, statement, tj. unosimo podatke u bazu/
    // I Execute izvrsavamo pripremljenu i azuriranu izjavu...
    public static void insertUser(User u) throws SQLException {
        Connection baza = DBConnection.getConn();
        String upit = "insert into User(username, password) values(?,?)";
        PreparedStatement ps = baza.prepareStatement(upit);
        // Na poziciji 1 je upit za username, Username u je objekat pa zato pisemo u.getUsername()...
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        ps.execute();

    }

    // Metoda za proveravanje podataka korisnika. Koristiomo select upit
    // Izvuci nam iz baze ove podatke(Username,password) ako postoje uspeno logovanje, ako ne niste ulogovani..
    static boolean checkUser(User u) throws SQLException {
        Connection baza = DBConnection.getConn();
        String upit = "select * from user where username =? and password =? ";
        PreparedStatement ps = baza.prepareStatement(upit);
        ps.setString(1, u.getUsername());
        ps.setString(2, u.getPassword());
        // Execute Querry izvrsi nad upitom, proveri da li postoje podadci u bazi, zato je ExecuteQuerry
        ResultSet rs = ps.executeQuery();
        return rs.next();
        // Ako je u bazi imamo ove podatke spusti se u sledecu kolonu(next) i vrati true
        // Ako ovih podataka nema znaci false...

    }

    static ArrayList<Category> getAllCategories() throws SQLException {
        Connection baza = DBConnection.getConn();
        String upit = "select*from category";
        PreparedStatement ps = baza.prepareStatement(upit);
        ResultSet rs = ps.executeQuery();
        // Kreiramo ArrayList Category i prolazimo u beskonacno interacija while petljom
        // Prilikom prolaska potrebno je da kreira novu kategoriju koja sadrzi id (rs.getInt i rs.getString) i ime kategorije
        // Nakon toga je dodaje i ispisuje korisniku (kategorije.add i return kategorije)
        // Ne znamo koliko podataka ima baza iz tog razloga koristimo ArrayList u kombinaciji sa while petljom.
        // while(rs.next()){ prolazi kroz listu  i kada while zavrsi posao return kategorije...
        // Posto while petlja cita podatke u beskonacno interacija kada procita jedan ona prelazi preko njega
        // Da bi smo ga sacuvali tj. dodali u ArrayList koristimo kategorije.add
        ArrayList<Category> kategorije = new ArrayList<>();
        while (rs.next()) {
            // rs.next , Dokle god je result truth radi nesto, tj. pravi kategoriju...
            Category c = new Category(rs.getInt(1), rs.getString(2));
            kategorije.add(c);
        }
        return kategorije;
    }
    // ArrayList za klasu Item konektujemo sa tabelom Item iz Baze, Tabela Item
    // je pod tabela tabele Category pa u zagradi ka argument metode imamo int kat
// Kreiramo metod u DBC koji ce iz DBMYSQL da dovlaci podatke pomocu upita

    static ArrayList<Item> getAllItemByCategory(int kat) throws SQLException {
        Connection baza = DBConnection.getConn();
        String upit = "select* from Item where category_id = ?";
        PreparedStatement ps = baza.prepareStatement(upit);
        ps.setInt(1, kat);
        ResultSet rs = ps.executeQuery();
        ArrayList<Item> proizvodi = new ArrayList<>();
        while(rs.next()){
            Item item = new Item(rs.getInt(1),rs.getInt(2),rs.getString(3));
            proizvodi.add(item);
            
        }
        return proizvodi;
                
    }
}
    

