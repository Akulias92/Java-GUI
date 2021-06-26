package GUI1Objasnjenja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/aliexpress";
    private String user = "root";
    private String password = "lujo92";
// Postavljamo konekciju na nulu. Ako je konekcija nula kreiraj  Singlton logiku konekcije koja je uvek Private.
    // Mozemo samo mi da napravimo ovu konekciju samo jednom...
    private Connection conn = null;
    private static DBConnection instance = null;
// Singlton logika, povezivanje bez instanci, objekata, nisu potrebne prethodno kreirane klase
// Konstruktor je private zato sto ako je public bilo ko moze da pozove konstruktor i kreira objekte a onda se gubi smisao..
// Niko ne moze da se poveze, da kreira konekciju, private..

    private DBConnection() throws SQLException {
        // inicijalizacija objekta Connection..
        
        conn = DriverManager.getConnection(url, user, password);
    }

    public static Connection getConn() throws SQLException {
        if (instance == null) {
            instance = new DBConnection();
        }

        return instance.conn;
    }

}
