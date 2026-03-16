public class Kamer extends Ruimte {

    private String classification;

    public Kamer(String areaType, String position, String dimension, String classification) {
        super(areaType,position, dimension);
        this.classification = classification;
    }

    public String getClassification() {
        return classification;
    }
}