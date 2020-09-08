package menufact.plats;

import inventaire.Inventaire;

public class platMenuCreate extends CreatorPlat {

    public PlatAuMenu createPlats(int code, String description, double prix, Inventaire Composition) throws PlatException {
        return new PlatAuMenu(code,description,prix,Composition);
    }


}