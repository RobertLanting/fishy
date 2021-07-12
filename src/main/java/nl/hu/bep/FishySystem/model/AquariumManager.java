package nl.hu.bep.FishySystem.model;

import java.util.ArrayList;

public class AquariumManager {

    private String installatienaam;
    private static ArrayList<Eigenaar> alleEigenaren = new ArrayList<>();
    private static ArrayList<Bewoner> alleBewoners = new ArrayList<>();
    private static ArrayList<Toebehoren> alleToebehoren = new ArrayList<>();

    public AquariumManager(String instalatienm) {
        this.installatienaam = instalatienm;
    }

    public static ArrayList<Eigenaar> getAlleEigenaren() {
        return alleEigenaren;
    }

    public static ArrayList<Bewoner> getAlleBewoners() {
        return alleBewoners;
    }

    public ArrayList<Toebehoren> getAlleToebehoren() {
        return alleToebehoren;
    }

    public static Eigenaar getEigenaar(String naam) {
        for (Eigenaar e : alleEigenaren) {
            if (e.getVoornaam().equals(naam)) {
                return e;
            }
        }
        return null;
    }

    public static void addEigenaar(Eigenaar e) {
        alleEigenaren.add(e);
    }

    public static void verwijderEigenaar(String voornaam) {
        alleEigenaren.removeIf(e -> e.getVoornaam().equals(voornaam));
    }
}
