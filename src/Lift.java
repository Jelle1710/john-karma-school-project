public class Lift extends Ruimte {

    private int verdieping;

    private boolean beschikbaar;

    public Lift(String areaType, String position, String dimension, int verdieping,  boolean beschikbaar) {
        super(areaType, position, dimension);
        this.verdieping = verdieping;
        this.beschikbaar = beschikbaar;
    }

    public void liftOmhoog(){
        verdieping--;
        this.setPositionY(verdieping);
    }
    public void liftOmlaag(){
        verdieping++;
        this.setPositionY(verdieping);
    }
    public void liftCalled(){

    }

    public int getVerdieping() {
        return verdieping;
    }
    public void setVerdieping(int verdieping) {
        this.verdieping = verdieping;
    }
    public boolean isBeschikbaar() {
        return beschikbaar;
    }
    public void setBeschikbaar(boolean beschikbaar) {
        this.beschikbaar = beschikbaar;
    }
}



