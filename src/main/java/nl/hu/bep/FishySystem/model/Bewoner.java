package nl.hu.bep.FishySystem.model;

public class Bewoner {

    private String soortnaam;
    private String kleurnaam;
    private int aantal;
    private boolean groepsDier;
    private String type;

    public Bewoner(String soortnm, String kleurnm, int aantal, boolean grpsdier, String type) {
        this.soortnaam = soortnm;
        this.kleurnaam = kleurnm;
        this.aantal = aantal;
        this.groepsDier = grpsdier;
        this.type = type;
    }

    public String getSoortnaam() {
        return soortnaam;
    }

    public String getKleurnaam() {
        return kleurnaam;
    }

    public int getAantal() {
        return aantal;
    }

    public boolean isGroepsDier() {
        return groepsDier;
    }

    public String getType() {
        return type;
    }
}
