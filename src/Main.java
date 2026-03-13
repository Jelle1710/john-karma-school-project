import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);

        // lees JSON en krijg layout
        LayoutParser parser = new LayoutParser();
        Layout layout = parser.parse("Layout1.json");
        Layout layoutFixed = parser.parse("Layout1Fixed.json");

        // bereken hotel grootte
        layout.berekenGridGrootte();
        layoutFixed.berekenGridGrootte();

        // voeg de lift, schachten, trappen en lobby toe
        layout.addverplichteElementen(layout);
        layout.addverplichteElementen(layoutFixed);

        // maak grid
        layout.maakGrid();
        layoutFixed.maakGrid();

        // plaats kamers
        layout.plaatsKamers();
        layoutFixed.plaatsKamers();


        JFrame frame2 = new JFrame("Hotel Layout Fixed");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(layoutFixed.getHotelPanel());
        frame2.pack();
        frame2.setVisible(true);

        JFrame frame1 = new JFrame("Hotel Layout"); // maak een nieuw scherm aan om de simulatie te tonen
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // als je het venster sluit stopt het programma
        frame1.add(layout.getHotelPanel()); // get het panel van de layout van het hotel en voeg deze toe aan het scherm
        frame1.pack(); // pas de grootte van het scherm aan gebaseerd op de grootte van wat erin zit
        frame1.setVisible(true); // laat het zien
    }
}