package GUI1Objasnjenja;

public class Item {
    
    private int id,cena;
    private String ime;
    
    public Item(){
    }

    public Item(int id, int cena, String ime) {
        this.id = id;
        this.cena = cena;
        this.ime = ime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", cena=" + cena + ", ime=" + ime + '}';
    }
    
}
