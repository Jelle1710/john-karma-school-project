import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Layout {

    private ArrayList<Kamer> kamers;

    private  ArrayList<Kamer> verplichteElementen;

    private HashMap<String, GridVakje> grid;

    private JPanel hotelPanel;

    private int vakHoogte = 60;
    private int vakBreedte = 120;

    private int gridBreedte;
    private int gridLengte;


    //constructor
    public Layout() {
        kamers = new ArrayList<>();
        verplichteElementen = new ArrayList<>();
        grid = new HashMap<>();
    }

    //add meegegeven kamer aan lijst van kamers
    public void addKamer(Kamer k) {
        kamers.add(k);
    }

    // bepaal hoe groot hotel moet zijn
    public void berekenGridGrootte() {

        for (Kamer k : kamers) { // voor aantal kamers in de lijst

            int right = k.getPositionX() + k.getDimensionW() - 1; // positie x plus hoe wijd de kamer is (-1 voor de x positie die al is meegerekend)
            int bottom = k.getPositionY() + k.getDimensionH() - 1; // positie y plus hoe hoog de kamer is (-1 voor de y positie die al is meegerekend)

            if (right > gridBreedte) { //zoek de meest rechtse positie+wijdte
                gridBreedte = right; // dat is nu de breedte
            }
            if (bottom > gridLengte) { //zoek de meest onderste positie+hoogte
                gridLengte = bottom; // dat is nu de lengte
            }
        }
        gridBreedte = gridBreedte +2; // 2 extra kolommen voor de trap en liftschacht
        gridLengte = gridLengte +1; // 1 extra rij voor de lobby
    }

    // maak alle grid vakjes
    public void maakGrid() {

        hotelPanel = new JPanel(null); // panel aanmaken voor de layout met een custom grid layout
        hotelPanel.setPreferredSize(new Dimension(gridBreedte * vakBreedte, gridLengte * vakHoogte)
                // bepaal aantal rijen (breedte) en hoe wijd die zijn (vakbreedte) en bepaal het aantal kolommen (lengte) en hoe hoog die zijn (vakhoogte)
        );

        for (int y = 0; y < gridLengte; y++) {
            for (int x = 0; x < gridBreedte; x++) {

                GridVakje vak = new GridVakje(x, y, vakBreedte, vakHoogte); // maak een nieuw gridvakje aan per gecreëerde kolom en rij

                grid.put(x + "," + y, vak); // voeg deze toe aan de lijst met gridvakjes

                hotelPanel.add(vak.getVakjepanel()); // voeg het vakje toe aan de hotelpanel voor de layout
            }
        }
    }

    // plaats kamers

    public void plaatsKamers() {
        for (Kamer kamer : kamers) { // voor elke kamer in de lijst van kamers
            int startX = kamer.getPositionX() ; // get de X positie -1 (de lift zit al op 0,0 dus we doen geen -1)
            int startY = kamer.getPositionY() -1; // get de Y positie -1 (posities beginnen vanaf 1 dus -1)

            int w = kamer.getDimensionW(); // get de wijdte
            int h = kamer.getDimensionH(); // get de lengte

            for (int y = startY; y < startY + h; y++) { // start bij de y positie, voor elke stap die kleiner is dan y + de hoogte
                for (int x = startX; x < startX + w; x++) { // start bij de x positie, voor elke stap die kleiner is dan x + de breedte

                    GridVakje vak = getGridVakje(x, y); // get het gridvakje die bij die coordinaten hoort

                    if (vak != null) { // als die bestaat
                        vak.zetInhoud(kamer.getAreaType(), kamer.getClassification()); // zet de inhoud van het vakje en geef het type en de classificatie mee (aantal sterren)

                        // bepaal of dit vakje een top-rand moet hebben
                        boolean top;
                        if (y == startY) { // als de y hetzelfde is als de y van de gegeven positie (linksboven)
                            top = true; // topborder moet er komen want dit is de bovenrand
                        } else {
                            top = false; // anders niet
                        }

                        // bepaal of dit vakje een bottom-rand moet hebben
                        boolean bottom;
                        if (y == startY + h - 1) { // start y + hoogte - 1 omdat de y al een van de hoogte vakjes bevat
                            bottom = true;
                        } else {
                            bottom = false;
                        }

                        // bepaal of dit vakje een left-rand moet hebben
                        boolean left;
                        if (x == startX) {
                            left = true;
                        } else {
                            left = false;
                        }

                        // bepaal of dit vakje een right-rand moet hebben
                        boolean right;
                        if (x == startX + w - 1) {
                            right = true;
                        } else {
                            right = false;
                        }

                        vak.setBorder(top, left, bottom, right);
                    }
                }
            }
        }
        for (Kamer element : verplichteElementen) { // voor elke element in de lijst van verplichte elementen
            int startX = element.getPositionX() -1; // get de Y positie -1 (posities beginnen vanaf 1 dus -1)
            int startY = element.getPositionY() -1; // get de Y positie -1 (posities beginnen vanaf 1 dus -1)

            int w = element.getDimensionW(); // get de wijdte
            int h = element.getDimensionH(); // get de lengte

            for (int y = startY; y < startY + h; y++) { // start bij de y positie, voor elke stap die kleiner is dan y + de hoogte
                for (int x = startX; x < startX + w; x++) { // start bij de x positie, voor elke stap die kleiner is dan x + de breedte

                    GridVakje vak = getGridVakje(x, y); // get het gridvakje die bij die coordinaten hoort

                    if (vak != null) { // als die bestaat
                        vak.zetInhoud(element.getAreaType(), element.getClassification()); // zet de inhoud van het vakje en geef het type en de classificatie mee (aantal sterren)

                        // bepaal of dit vakje een top-rand moet hebben
                        boolean top;
                        if (y == startY) { // als de y hetzelfde is als de y van de gegeven positie (linksboven)
                            top = true; // topborder moet er komen want dit is de bovenrand
                        } else {
                            top = false; // anders niet
                        }

                        // bepaal of dit vakje een bottom-rand moet hebben
                        boolean bottom;
                        if (y == startY + h - 1) { // start y + hoogte - 1 omdat de y al een van de hoogte vakjes bevat
                            bottom = true;
                        } else {
                            bottom = false;
                        }

                        // bepaal of dit vakje een left-rand moet hebben
                        boolean left;
                        if (x == startX) {
                            left = true;
                        } else {
                            left = false;
                        }

                        // bepaal of dit vakje een right-rand moet hebben
                        boolean right;
                        if (x == startX + w - 1) {
                            right = true;
                        } else {
                            right = false;
                        }

                        vak.setBorder(top, left, bottom, right);
                    }
                }
            }
        }
    }

    // getters en setters

    public JPanel getHotelPanel() {
        return hotelPanel;
    }

    public GridVakje getGridVakje(int x, int y) {
        String coordinaten = x+","+y;
        return grid.get(coordinaten);
    }

    public void addverplichteElementen(Layout layout) {
        String schachtDimension = "1," + gridLengte/2;
        layout.addKamerBuitenJson("Schacht", "1,1", schachtDimension, 9999, null);
        String verdiepingLift = "1," + (gridLengte+1)/2;
        layout.addKamerBuitenJson("Lift", verdiepingLift, "1,1", 9999, null);
        String schachtStart = "1," + (gridLengte/2 + 2);
        layout.addKamerBuitenJson("Schacht", schachtStart, schachtDimension, 9999, null);
        String trappenPosition = gridBreedte + ",1";
        String trappenDimension = "1," + gridLengte;
        layout.addKamerBuitenJson("Trappen", trappenPosition, trappenDimension, 9999, null);
        String lobbyPosition = "2," + gridLengte;
        String lobbyDimension = gridLengte-3 + ",1";
        layout.addKamerBuitenJson("Lobby", lobbyPosition, lobbyDimension, 9999, null);
    }

    public void addKamerBuitenJson(String AreaType, String position, String dimension, long capacity, String classification){
        if (AreaType.equals("Lift")) {
            verplichteElementen.add( new Lift(AreaType, position, dimension, capacity, classification, (gridLengte + 1) / 2));
        } else verplichteElementen.add(new Kamer(AreaType, position, dimension, capacity, classification));
    }
}