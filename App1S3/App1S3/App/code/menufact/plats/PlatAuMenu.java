package menufact.plats;

import inventaire.Inventaire;

public class PlatAuMenu {
    private int code;
    private String description;
    private double prix;
    private Inventaire composition;

    public PlatAuMenu(int code, String description, double prix, double filler1, double filler2, double filler3, Inventaire composition) {
        this.code = code;
        this.description = description;
        this.prix = prix;
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

    public void setCode(int code) {
        this.code = code;
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

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
