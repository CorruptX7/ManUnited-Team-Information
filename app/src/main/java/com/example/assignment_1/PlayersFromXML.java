package com.example.assignment_1;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.io.Serializable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class PlayersFromXML implements Serializable {

    private Player [] players;
    private Context context;

    // Constructor
    public PlayersFromXML(Context context) {

        this.context = context;

        // The parsing
        // Open a stream to the XML file & a DocBuilder & Doc
        // Declare stream, builder and xml
        InputStream stream = null;
        DocumentBuilder builder = null;
        Document xmlDoc = null;

        try {

            stream = this.context.getResources().openRawResource(R.raw.players);
            // No constructor so we're going to the factory to get a new builder
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Builder parses
            xmlDoc = builder.parse(stream);

        }
        catch (Exception e) {

        }

        // Slide xmlDoc to NodeList (Slicing generates a NodeList) - Copped the document into node list. Example below.
        // Get a list of names, phone numbers etc.
        NodeList thumbnailList          = xmlDoc.getElementsByTagName("thumbnail");
        NodeList imageList          = xmlDoc.getElementsByTagName("image");
        NodeList nameList           = xmlDoc.getElementsByTagName("name");
        NodeList fullnameList           = xmlDoc.getElementsByTagName("fullname");
        NodeList numberList         = xmlDoc.getElementsByTagName("number");
        NodeList positionList       = xmlDoc.getElementsByTagName("position");
        NodeList ageList            = xmlDoc.getElementsByTagName("age");
        NodeList appearancesList    = xmlDoc.getElementsByTagName("appearances");
        NodeList goalsList          = xmlDoc.getElementsByTagName("goals");
        NodeList countryList        = xmlDoc.getElementsByTagName("country");
        NodeList joinedList         = xmlDoc.getElementsByTagName("joined");
        NodeList quoteList          = xmlDoc.getElementsByTagName("quote");
        NodeList kitList          = xmlDoc.getElementsByTagName("kit-image");
        NodeList kiturlList          = xmlDoc.getElementsByTagName("kit-link");
        NodeList kitPriceList          = xmlDoc.getElementsByTagName("kit-price");
        NodeList urlList            = xmlDoc.getElementsByTagName("url");


        // Make people (Make an array of people)
        players = new Player[nameList.getLength()];

        // Create each person in this person array
        for (int i = 0; i < players.length; i = i + 1) {
            // Get first child and then get the value
             String thumbnail    = thumbnailList.item(i).getFirstChild().getNodeValue();
             String image    = imageList.item(i).getFirstChild().getNodeValue();
             String name    = nameList.item(i).getFirstChild().getNodeValue();
             String fullname    = fullnameList.item(i).getFirstChild().getNodeValue();
             String number   = numberList.item(i).getFirstChild().getNodeValue();
             String position = positionList.item(i).getFirstChild().getNodeValue();
             String age   = ageList.item(i).getFirstChild().getNodeValue();
             String appearances     = appearancesList.item(i).getFirstChild().getNodeValue();
             String goals     = goalsList.item(i).getFirstChild().getNodeValue();
             String country     = countryList.item(i).getFirstChild().getNodeValue();
             String joined     = joinedList.item(i).getFirstChild().getNodeValue();
             String quote     = quoteList.item(i).getFirstChild().getNodeValue();
             String kit     = kitList.item(i).getFirstChild().getNodeValue();
             String kiturl     = kiturlList.item(i).getFirstChild().getNodeValue();
             String kitprice     = kitPriceList.item(i).getFirstChild().getNodeValue();
             String url     = urlList.item(i).getFirstChild().getNodeValue();

             players[i] = new Player(thumbnail, image, name, fullname, number, position, age, appearances, goals, country, joined, quote, kit, kiturl, kitprice, url);
        }

    }

    // 3 methods
    public int getLength() {
        return players.length;
    }

    public Player getPlayer(int index) {
        return players[index];
    }

    public Player [] getPlayerList() {
        return players;
    }

    public String [] getNames() {
        String [] names = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            names[i] = getPlayer(i).getName();
        }
        return names;
    }

    public String [] getFullNames() {
        String [] names = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            names[i] = getPlayer(i).getFullname();
        }
        return names;
    }

    public String [] getThumbnails() {
        String [] images = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            images[i] = getPlayer(i).getThumbnail();
        }
        return images;
    }

    public String [] getKits() {
        String [] names = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            names[i] = getPlayer(i).getKit();
        }
        return names;
    }

    public String [] getKitPrices() {
        String [] names = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            names[i] = getPlayer(i).getKitprice();
        }
        return names;
    }

    public String [] getNumbers() {
        String [] positions = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            positions[i] = getPlayer(i).getNumber();
        }
        return positions;
    }

    public String [] getGoals() {
        String [] positions = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            positions[i] = getPlayer(i).getGoals();
        }
        return positions;
    }

    public String [] getPositions() {
        String [] positions = new String [getLength()];
        for (int i = 0; i < getLength(); i = i + 1) {
            positions[i] = getPlayer(i).getPosition();
        }
        return positions;
    }
}
