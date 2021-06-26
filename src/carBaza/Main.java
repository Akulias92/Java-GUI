package carBaza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String run, start;
    static int list, update, select, member, startAgain;
    static boolean isNum1;

    public static void main(String[] args) throws SQLException {
        
        long totalMilesSecond = System.currentTimeMillis();
        long seconds = totalMilesSecond/1000;
        long currentSeconds = seconds%60;
        long minutes = seconds/60;
        long currentMinutes = minutes%60;
        long hours = minutes/60;
        long currentHour = hours%24+1;
        System.out.println("Current time: " + currentHour + ":" + currentMinutes + ":" + currentSeconds);

        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.print("Enter username: ");
        String username = sc.next();
        System.out.print("Enter your password: ");
        String password = sc.next();
        insertUser(name, username, password);
        System.out.println("Hello " + username + " :)");
        System.out.print("Press any key to continue: ");
        start = sc.next();
        
        System.out.print("Confirm your password: ");
        String retype = sc.next();
        
        if (retype.equals(password)) {
            do {

                boolean isNum;
                do {

                    System.out.println("\nWELCOME :)");
                    System.out.println("SELECT AN OPTION: ");
                    System.out.println("1 - CREATE CAR");
                    System.out.println("2 - DISPLAY CAR TABLE");
                    System.out.println("3 - UPDATE CAR");
                    System.out.println("4 - DELETE CAR");
                    System.out.println("5 - EXIT THE PROGRAM");

                    if (sc.hasNextInt()) {
                        select = sc.nextInt();
                        isNum = true;
                    } else {
                        System.out.println("Please, enter 1,2,3,4 or 5 to select an option :)");
                        isNum = false;
                        sc.next();
                    }

                } while (!(isNum) || (select >= 6) || (select == 0));

                switch (select) {
                    case (1):
                        System.out.print("Enter the number of the cars you want to insert:  ");
                        int carNumber = sc.nextInt();
                        int count = 0;
                        do {
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("Car: " + count);
                            System.out.println("-------------------------------------------------------------");
                            System.out.print("Enter the car name: ");
                            String name1 = sc.next();
                            System.out.print("Enter the car color: ");
                            String color = sc.next();
                            System.out.print("Enter the car price: ");
                            Double price = sc.nextDouble();
                            System.out.print("Enter the selling currency: ");
                            String currency = sc.next();
                            System.out.print("Enter the date of manufacture of the car: ");
                            int year = sc.nextInt();
                            importCars(name1, color, price, currency, year);
                            count++;
                        } while (count < carNumber);
                        System.out.println("\nYou have successfully entered the car into the database :)");
                        break;

                    case (2):
                        System.out.println("Car table: ");
                        getCars();
                        break;

                    case (3):
                        boolean isNum1;
                        do {
                            System.out.println("UPDATE: ");
                            System.out.println("Press 1 to update car name");
                            System.out.println("Press 2 to update car color");
                            System.out.println("Press 3 to update car price");
                            System.out.println("Press 4 to update year of car production");

                            if (sc.hasNextInt()) {
                                update = sc.nextInt();
                                isNum1 = true;
                            } else {
                                System.out.println("Please, enter 1,2,3 or 4 to select an option :)");
                                isNum1 = false;
                                sc.next();
                            }

                        } while (!(isNum1) || (update >= 5) || (update == 0));

                        switch (update) {
                            case (1):
                                System.out.println("See the car list and select the id you want to update \n(To see list press number 2)");
                                list = sc.nextInt();
                                if (list == 2) {
                                    System.out.println("Car table: ");
                                    getCars();
                                } else {
                                    System.out.println("Wrong! \n(For car_id list press number 2)");
                                    break;
                                }
                                System.out.print("Enter new name: ");
                                String newName = sc.next();
                                System.out.print("Enter the car id: ");
                                int id1 = sc.nextInt();
                                updateCarName(newName, id1);
                                System.out.println("You successfully updated car with id " + id1 + " :)");
                                break;
                            case (2):
                                System.out.println("See the car list and select the id you want to update \n(To see list press number 2)");
                                list = sc.nextInt();
                                if (list == 2) {
                                    System.out.println("Car table: ");
                                    getCars();
                                } else {
                                    System.out.println("Wrong! \n(For car_id list press number 2)");
                                    break;
                                }
                                System.out.print("Enter new color: ");
                                String newColor = sc.next();
                                System.out.print("Enter the car id: ");
                                int id2 = sc.nextInt();
                                updateCarColor(newColor, id2);
                                System.out.println("You successfully updated car with id " + id2 + " :)");
                                break;
                            case (3):
                                System.out.println("See the car list and select the id you want to update \n(To see list press number 2)");
                                list = sc.nextInt();
                                if (list == 2) {
                                    System.out.println("Car table: ");
                                    getCars();
                                } else {
                                    System.out.println("Wrong! \n(For car_id list press number 2)");

                                }
                                System.out.println("Enter the car id: ");
                                int id3 = sc.nextInt();
                                System.out.print("Enter new price: ");
                                double newPrice = sc.nextDouble();
                                updateCarPrice(id3, newPrice);
                                System.out.println("\nYou successfully updated car with id " + id3 + " :)");
                                break;

                            case (4):
                                System.out.println("See the car list and select the id you want to update \n(To see list press number 2)");
                                list = sc.nextInt();
                                if (list == 2) {
                                    System.out.println("Car table: ");
                                    getCars();
                                } else {
                                    System.out.println("Wrong! \n(For car_id list press number 2)");
                                    break;
                                }
                                System.out.println("Enter the car id: ");
                                int id4 = sc.nextInt();
                                System.out.print("Enter new year: ");
                                int newYear = sc.nextInt();
                                updateCarYear(id4, newYear);
                                System.out.println("\nYou successfully updated car with id " + id4 + " :)");
                        }
                        break;
                    case (4):
                        System.out.println("See the car list and select the id you want to update \n(To see list press number 2)");
                        list = sc.nextInt();
                        if (list == 2) {
                            System.out.println("Car table: ");
                            getCars();
                        } else {
                            System.out.println("Wrong! \n(For car_id list press number 2)");
                            break;
                        }
                        System.out.print("Enter the number of the cars you want to delete:  ");
                        int carDelete = sc.nextInt();
                        int counter = 0;
                        do {
                            System.out.print("Enter the car id  you want to delete: ");
                            int id = sc.nextInt();
                            deleteCar(id);
                            System.out.println("\nYou successfully deleted the car with id " + id + " :)");
                            counter++;
                        } while (counter < carDelete);
                        break;
                    case (5):
                        if (select == 5) {
                            System.out.println("Goodbye ");
                        }
                }

                System.out.println("If you want to start program again press any key ?");
                if (sc.hasNextInt()) {
                    startAgain = sc.nextInt();
                    isNum1 = true;
                } else {
                    isNum1 = false;
                    System.out.println("Please, press any key to run the program :)s"
                            + "");
                }

            } while (!(isNum1) || (startAgain == 1) || (startAgain != 1));
            sc.close();
        } else {
            System.out.println("Your password is incorrect!");
        }
    }

    public static Connection getConn() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/automobili?autoReconnect=true&useSSL=false";
        String user = "root";
        String password = "lujo92";
        // Static method koji se poziva nad klasom.
        Connection connDatabase = DriverManager.getConnection(url, user, password);
        return connDatabase;
    }

    //DELETE CAR FROM TABLE
    public static void deleteCar(int auto_id) throws SQLException {
        String query = "delete from auto where auto_id=" + auto_id;
        Connection connDatabase = getConn();
        Statement st = connDatabase.createStatement();
        st.execute(query);
    }

    //UPDATE CAR 
    public static void updateCarName(String name, int auto_id) throws SQLException {
        String query = "update auto set ime= " + name + " where auto_id= " + auto_id;
        Connection connDatabase = getConn();
        Statement st = connDatabase.createStatement();
        st.execute(query);
    }

    public static void updateCarColor(String color, int auto_id) throws SQLException {
        String query = "update auto set boja= " + color + " where auto_id= " + auto_id;
        Connection database = getConn();
        Statement st = database.createStatement();
        st.execute(query);
    }

    public static void updateCarPrice(int auto_id, double price) throws SQLException {
        String query = "update auto set cena= " + price + " where auto_id= " + auto_id;
        Connection connDatabase = getConn();
        Statement st = connDatabase.createStatement();
        st.execute(query);
    }

    public static void updateCarYear(int auto_id, int year) throws SQLException {
        String query = "update auto set godina_proizvodnje= " + year + " where auto_id= " + auto_id;
        Connection database = getConn();
        Statement st = database.createStatement();
        st.execute(query);
    }

    //READ FROM DATABASE
    public static void getCars() throws SQLException {
        Connection connDatabase = getConn();
        Statement st = connDatabase.createStatement();
        ResultSet rs = st.executeQuery("select auto_id, ime, boja, cena, valuta, godina_proizvodnje from auto");
        while (rs.next()) {
            System.out.println(rs.getInt("auto_id") + "\t" + rs.getString("ime")
                    + "\t\t" + rs.getString("boja") + "\t"
                    + rs.getDouble("cena") + "\t" + rs.getString("valuta") + "\t" + rs.getInt("godina_proizvodnje"));
        }
    }

    // CREATE CAR INSERT
    public static void importCars(String name, String color, Double price, String currency, int year) throws SQLException {
        Connection connDatabase = getConn();
        String query = "insert into auto(ime,boja,cena,valuta,godina_proizvodnje)" + "values ('" + name + "', '" + color + "', " + price + ", '" + currency + "','" + year + "');";
        //Kreiranje SQL upita za ubacivanje atributa automobila u bazu
        // Izvrsavanje upita vrsi se uz pomoc Statement, execute String koji je poslat
        Statement st = connDatabase.createStatement();
        st.execute(query);
    }
    // INSERT USER
    public static void insertUser(String name, String username, String password) throws SQLException {
        Connection conn = getConn();
        String query = "insert into account(name,username,password)" + "values ('" + name + "', '" + username + "', '" + password + "');";
        Statement st = conn.createStatement();
        st.execute(query);
    }
}
