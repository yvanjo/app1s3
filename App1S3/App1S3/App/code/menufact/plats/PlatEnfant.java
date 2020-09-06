package menufact.plats;

import inventaire.Inventaire;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix,double filler1, double filler2,double proportion, Inventaire Composition) {
        super(code, description, prix,filler1,filler2, 0.00 ,Composition);
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
