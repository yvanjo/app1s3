package menufact.plats;

import inventaire.Inventaire;

public class platMenu extends CreatorPlat {

    @Override
    public PlatAuMenu createPlats(int code, String description, double prix, double kcal, double chol, double gras, Inventaire Composition) {
        return new PlatAuMenu(code,description,prix,0.00,0.00,0.00,Composition);
    }


}