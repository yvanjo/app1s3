package menufact.plats;

import inventaire.Inventaire;
import menufact.plats.PlatAuMenu;

public class   PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras, Inventaire Composition) throws PlatException {
        super(code, description, prix,Composition);
        setChol(chol);
        setKcal(kcal);
        setGras(gras);

    }

    public PlatSante() {
    }

    @Override
    public double getProportion() {
        return 1.00;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    public double getKcal() {
        return kcal;
    }

    public double getChol() {
        return chol;
    }

    public double getGras() {
        return gras;
    }

    private void setKcal(double kcal) throws PlatException {
        if(kcal < 0)
        {
            throw new PlatException("kcal can't be under 0");
        }
        else{
            this.kcal = kcal;
        }
    }
    private void setChol(double Chol) throws PlatException {
        if(Chol < 0)
        {
            throw new PlatException("Chol can't be under 0");
        }
        else{
            this.chol = Chol;
        }
    }
    private void setGras(double Gras) throws PlatException {
        if(Gras < 0)
        {
            throw new PlatException("Gras can't be under 0");
        }
        else{
            this.gras = Gras;
        }
    }
}
