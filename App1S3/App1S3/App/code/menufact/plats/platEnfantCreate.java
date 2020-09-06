package menufact.plats;

public class platEnfantCreate implements CreatorPlat {
    @Override
    public plat createPlats(int code, String description, double prix, double proportion, Inventaire Composition) {
        return new PlatEnfant(code,description,prix,proportion,Composition);
    }
}
