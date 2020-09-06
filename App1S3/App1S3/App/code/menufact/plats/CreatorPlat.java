package menufact.plats;

import inventaire.Inventaire;

public class CreatorPlat {
   public PlatAuMenu createPlats(int code, String description, double prix, double kcal, double chol, double gras, Inventaire Composition) {
      return null;
   }


   public PlatAuMenu renderPlat(int code, String description, double prix, double kcal, double chol, double gras, Inventaire Composition)
   {
      PlatAuMenu unplat = createPlats(code,description,prix,kcal,chol,gras,Composition);
      return unplat;
   }

   public PlatAuMenu renderPlat(int code, String description, double prix,double proportion, Inventaire Composition)
   {
      PlatAuMenu unplat = createPlats(code,description,prix,0.00,0.00,proportion,Composition);
      return unplat;
   }

   public PlatAuMenu renderPlat(int code, String description, double prix, Inventaire composition)
   {
      PlatAuMenu unplat = createPlats(code, description, prix, 0.00,0.00,0.00,composition);
      return unplat;
   }
}
