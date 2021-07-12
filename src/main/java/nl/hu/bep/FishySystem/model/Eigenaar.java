package nl.hu.bep.FishySystem.model;

import java.util.ArrayList;

public class Eigenaar {

    private String voornaam;
    private String achternaam;
    private ArrayList<Toebehoren> toebehoren = new ArrayList<>();
    private ArrayList<Aquarium> aquaria = new ArrayList<>();


    public Eigenaar(String voornm, String achternm) {
        this.voornaam = voornm;
        this.achternaam = achternm;
    }

    public static boolean login(String voornaam, String achternaam) {
        for (Eigenaar e : AquariumManager.getAlleEigenaren()) {
            if (e.getVoornaam().equals(voornaam) && e.getAchternaam().equals(achternaam)) {
                return true;
            }
        }
        return false;
    }

    public void voegToebehorenToe(Toebehoren toebehoren) {
        this.toebehoren.add(toebehoren);
    }

    public void voegAquariumToe(Aquarium a) {
        aquaria.add(a);
    }

    public void verwijderAquarium(String naam) {

        aquaria.removeIf(a -> a.getNaam().equals(naam));
    }

    public void verwijdertoebehoor(String toebehoor) {
        toebehoren.removeIf(a -> a.getSerienummer().toString().equals(toebehoor));
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public ArrayList<Toebehoren> getToebehoren() {
        return toebehoren;
    }

    public ArrayList<Aquarium> getAquaria() {
        return aquaria;
    }

    public Aquarium vindAquarium(String naam) {
        for (Aquarium a : aquaria) {
            if (a.getNaam().equals(naam)) {
                return a;
            }
        }
        return null;
    }


}
