import javax.swing.*;

public class Klok {

    private Event event;

    private int hotelTijdsEenheid;

    public Klok(Event event,  int hotelTijdEenheid){
        this.event = event;
    }

    public void startKlok(){
        Timer timer = new Timer(1000, event);
        timer.start();
    }

    public void stopKlok(){
    }

    public void pauseKlok(){

    }

    public int getTime(){
        return hotelTijdsEenheid;
    }
}
