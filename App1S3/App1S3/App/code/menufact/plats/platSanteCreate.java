package menufact.plats;

public class platSanteCreate implements CreatorPlat {
    @Override
    public plat createPlats(int code, String description, double prix, double kcal, double chol, double gras, Inventaire Composition){
        return new PlatSante(code,description,prix,kcal,chol,gras,Composition);
    }
}
