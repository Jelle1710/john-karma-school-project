import java.util.ArrayList;

public class Receptie {

    private ArrayList<Kamer> kamers;

    private ArrayList<Kamer> legeKamers;
    private ArrayList<Gast> gasten;

    public Receptie(ArrayList<Kamer> kamers, ArrayList<Kamer> legeKamers, ArrayList<Gast> gasten) {
        this.kamers = kamers;
        this.legeKamers = legeKamers;
        this.gasten = gasten;
    }

    public void gastCheckIn(){

    }
    public void gastCheckOut(){

    }
    public ArrayList<Kamer> getLegeKamers() {
        return legeKamers;
    }
    public void setKamerLeeg(Kamer kamer) {
        legeKamers.add(kamer);
    }
    public void setKamerVol(Kamer kamer) {
        legeKamers.remove(kamer);
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }
    public void addKamers(ArrayList<Kamer> kamers) {
        this.kamers = kamers;
    }
    public ArrayList<Gast> getGasten() {
        return gasten;
    }
    public void addGasten(ArrayList<Gast> gasten) {
        this.gasten = gasten;
    }
}
