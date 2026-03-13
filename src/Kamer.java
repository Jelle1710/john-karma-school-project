public class Kamer {

    private String areaType;
    private String position;
    private String dimension;
    private long capacity;
    private String classification;

    // constructor

    public Kamer(String areaType, String position, String dimension, long capacity, String classification) {
        this.areaType = areaType; // zet areatype
        this.position = position; // zet position
        this.dimension = dimension; // zet dimension
        this.capacity = capacity; // zet capaciteit
        this.classification = classification; // zet de classificatie
    }

    //  print alle info over de kamer
    public void printInfo() {
        System.out.println(this);
        System.out.println("Area: " + areaType);
        System.out.println("Position: " + position);
        System.out.println("Dimension: " + dimension);
        System.out.println("Capacity: " + capacity);
        System.out.println("Classification: " + classification);
        System.out.println("-----------------");

    }

    // getters en setters

    public String getAreaType() {
        return areaType;
    }
    public int getPositionX() {
        String[] pos = position.split(",");
        int x = Integer.parseInt(pos[0].trim());
        return x;
    }

    public int getPositionY() {
        String[] pos = position.split(",");
        int y = Integer.parseInt(pos[1].trim());
        return y;
    }

    public void setPositionY(int y) {
        String newpositionY = getPositionX() + "," + y;
        this.position = newpositionY;
    }

    public int getDimensionW() {
        String[] dim = dimension.split(",");
        int w = Integer.parseInt(dim[0].trim());
        return w;
    }

    public int getDimensionH() {
        String[] dim = dimension.split(",");
        int h = Integer.parseInt(dim[1].trim());
        return h;
    }

    public long getCapacity() {
        return capacity;
    }
    public String getClassification() {
        return classification;
    }
}