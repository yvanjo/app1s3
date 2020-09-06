package menufact.plats;

public interface CreatorPlat {
   public plat createPlats(int code, String description, double prix, double kcal, double chol, double gras, Inventaire Composition);
   public plat creatPlats(int code, String description, double prix, double proportion, Inventaire Composition);
   public plat creatPlats(int code, String description, double prix, Inventaire composition);
}
