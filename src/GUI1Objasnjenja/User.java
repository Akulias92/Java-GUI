package GUI1Objasnjenja;

public class User {

    private int id;
    private String username, password;

    public User() {
    }

    // Pravljenej kopije User konstruktora koji kao argument sdrzi objekat User A..
    public User(User A) {
        this.id = A.id;
        this.username = A.username;
        this.password = A.password;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }

}
