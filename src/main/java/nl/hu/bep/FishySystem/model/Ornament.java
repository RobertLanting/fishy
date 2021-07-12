package nl.hu.bep.FishySystem.model;

public class Ornament {

    private String naam;
    private String omschrijving;
    private String kleur;
    private boolean kanOpLuchtpomp;

    public Ornament(String nm, String om, String kleur, boolean oplucht) {
        this.naam = nm;
        this.omschrijving = om;
        this.kleur = kleur;
        this.kanOpLuchtpomp = oplucht;
    }

    public String getNaam() {
        return naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getKleur() {
        return kleur;
    }

    public boolean isKanOpLuchtpomp() {
        return kanOpLuchtpomp;
    }
}
