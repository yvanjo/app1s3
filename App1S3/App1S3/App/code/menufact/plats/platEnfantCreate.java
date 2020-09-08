package menufact.plats;

import inventaire.Inventaire;

public class platEnfantCreate extends CreatorPlat {


    public PlatAuMenu createPlats(int code, String description,double prix,double proportion, Inventaire Composition) throws PlatException {
        return new PlatEnfant(code, description,prix,proportion,Composition);
    }

}
