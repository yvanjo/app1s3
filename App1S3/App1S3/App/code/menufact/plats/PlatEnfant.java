package menufact.plats;

import inventaire.Inventaire;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, double proportion, Inventaire Composition) {
        super(code, description, prix, Composition);
        this.proportion = proportion;
    }

    @Override
    public double getProportion() {
        return proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
