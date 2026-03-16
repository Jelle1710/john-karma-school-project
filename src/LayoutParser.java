    import java.io.FileNotFoundException;
    import java.io.FileReader;
    import java.io.IOException;

    import org.json.simple.JSONArray;
    import org.json.simple.JSONObject;
    import org.json.simple.parser.JSONParser;
    import org.json.simple.parser.ParseException;

    public class LayoutParser {

        public Layout parse(String file) throws IOException, ParseException {

            Layout layout = new Layout();

            // parser en layout array aanmaken
            JSONParser parser = new JSONParser();
            JSONArray layoutArray = (JSONArray) parser.parse(new FileReader(file));

            for (Object obj : layoutArray) { // voor aantal objecten (ruimten) in de file

                JSONObject ruimte = (JSONObject) obj; // object ruimte aanmaken

                String areaType = (String) ruimte.get("AreaType"); // get AreaType
                String position = (String) ruimte.get("Position"); // get Position
                String dimension = (String) ruimte.get("Dimension"); // get Dimension

                long capacity = ruimte.get("Capacity") != null // als de capaciteit niet null is
                        ? (long) ruimte.get("Capacity") // get capaciteit
                        : 9999; // anders zet de capaciteit op 9999

                String classification = (String) ruimte.get("Classification"); // get classificatie


                // maak een nieuwe kamer aan met de attributen die we net hebben opgehaald

                switch (areaType) {
                    case "Room":
                        Ruimte kamer = new Kamer(areaType, position, dimension, classification);
                        // zet de kamer in de layout
                        layout.addKamer(kamer);
                        break;
                    case "Restaurant":
                        Ruimte restaurant = new Restaurant(areaType, position, dimension, capacity);
                        layout.addKamer(restaurant);
                        break;
                    case "Fitness":
                        Ruimte fitness = new Fitness(areaType, position, dimension);
                        layout.addKamer(fitness);
                        break;
                    case "Cinema":
                        Ruimte bios = new Bioscoop(areaType, position, dimension);
                        layout.addKamer(bios);
                        break;
                    default:
                        break;
                }

            }
            return layout; // return de layout
        }
    }