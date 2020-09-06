package menufact.plats;

import inventaire.Inventaire;

public class platSanteCreate extends CreatorPlat {
    @Override
    public PlatAuMenu createPlats(int code, String description, double prix, double kcal, double chol, double gras, Inventaire Composition){
        return new PlatSante(code,description,prix,kcal,chol,gras,Composition);
    }


}
