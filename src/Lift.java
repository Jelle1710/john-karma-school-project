import javax.swing.*;

public class Lift extends Ruimte {

    private int verdieping;

    public Lift(String areaType, String position, String dimension, int verdieping) {
        super(areaType, position, dimension);
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



