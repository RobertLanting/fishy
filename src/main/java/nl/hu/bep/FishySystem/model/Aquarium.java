package nl.hu.bep.FishySystem.model;

import java.util.ArrayList;

public class Aquarium {

    private String naam;
    private int lengte;
    private int breedte;
    private int hoogte;
    private String bodemsoort;
    private String watersoort;
    private ArrayList<Ornament> ornamenten = new ArrayList<>();
    private ArrayList<Bewoner> bewoners = new ArrayList<>();

    public Aquarium(String nm, int len, int br, int hgte, String bodem, String water) {
        this.naam = nm;
        this.lengte = len;
        this.breedte = br;
        this.hoogte = hgte;
        this.bodemsoort = bodem;
        this.watersoort = water;
    }


    public void voegBewonerToe(Bewoner bewoner) {
        bewoners.add(bewoner);
        AquariumManager.getAlleBewoners().add(bewoner);
    }

    public void verwijderBewoner(String soortnaam) {
        bewoners.removeIf(b -> b.getSoortnaam().equals(soortnaam));
    }

    public void voegOrnamentToe(Ornament ornament) {
        ornamenten.add(ornament);
    }

    public void verwijderOrnament(String naam) {
        ornamenten.removeIf(o -> o.getNaam().equals(naam));
    }



    public String getNaam() {
        return naam;
    }

    public ArrayList<Ornament> getOrnamenten() {
        return ornamenten;
    }

    public ArrayList<Bewoner> getBewoners() {
        return bewoners;
    }

    public int getLengte() {
        return lengte;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public String getBodemsoort() {
        return bodemsoort;
    }

    public String getWatersoort() {
        return watersoort;
    }
}
