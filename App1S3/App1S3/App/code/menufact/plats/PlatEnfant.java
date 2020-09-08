package menufact.plats;

import inventaire.Inventaire;

public class PlatEnfant extends PlatAuMenu{
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix,double proportion, Inventaire Composition) throws PlatException {
        super(code, description, prix,Composition);
        setProportion(proportion);
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

    public void setProportion(double proportion) throws PlatException {
        if(proportion < 0)
        {
            throw new PlatException(" proportion is under 0");
        }
        else {
                this.proportion = proportion;
        }

    }
}
