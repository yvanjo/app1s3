package menufact.plats;

public class platMenu implements CreatorPlat {
    @Override
    public plat createPlats(int code, String description, double prix, Inventaire composition) {
        return new PlatAuMenu(code,description,prix,composition);
    }
}