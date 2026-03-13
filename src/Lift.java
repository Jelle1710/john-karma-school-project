import javax.swing.*;

public class Lift extends Kamer {

    private int verdieping;

    public Lift(String areaType, String position, String dimension, long capacity, String classification, int verdieping) {
        super(areaType, position, dimension, capacity, classification);
        this.verdieping = verdieping;
    }

    public void liftOmhoog(){
        verdieping--;
        this.setPositionY(verdieping);
    }
    public void liftOmlaag(){
        verdieping++;
        this.setPositionY(verdieping);
    }
}



