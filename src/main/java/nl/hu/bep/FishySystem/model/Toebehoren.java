package nl.hu.bep.FishySystem.model;

import java.util.UUID;

public class Toebehoren {

    private String model;
    private UUID serienummer;
    private String omschrijving;

    public Toebehoren(String model, String omschrijving) {
        this.model = model;
        this.omschrijving = omschrijving;
        this.serienummer = UUID.randomUUID();
    }

    public String getModel() {
        return model;
    }

    public UUID getSerienummer() {
        return serienummer;
    }

    public String getOmschrijving() {
        return omschrijving;
    }
}
