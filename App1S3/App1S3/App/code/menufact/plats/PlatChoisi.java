package menufact.plats;

import ingredients.IngredientInventaire;
import inventaire.Inventaire;
import menufact.plats.PlatAuMenu;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private Inventaire inventaire;
    public PlatChoisi(PlatAuMenu plat, int quantite, Inventaire inventaire) {
        this.plat = plat;
        this.quantite = quantite;
        this.inventaire = inventaire;
    }

    public Inventaire getInventaire()
    {
       return inventaire;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }
}
