package menufact.plats;

import inventaire.Inventaire;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private Inventaire composition;

    public PlatAuMenu(int code, String description, double prix, Inventaire composition) throws PlatException {
        setCode(code);
        this.description = description;
        setPrix(prix);
        this.composition = composition;
    }

    public Inventaire getComposition()
    {
        return this.composition;
    }

    public PlatAuMenu() {
    }


    public double getProportion() {
        return 1.00;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatAuMenu{" +
                "code=" + code +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                "}\n";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) throws PlatException {
        if(code < 0)
        {
            throw new PlatException("code ne peut pas etre plus petit que 0");
        }
        else{
            this.code =code;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) throws PlatException {
        if(prix <0)
        {
            throw new PlatException("Le prix ne peut pas etre inferieur à 0");
        }
        else{
            this.prix = prix;
        }
    }
}
