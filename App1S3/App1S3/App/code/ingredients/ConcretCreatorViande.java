package ingredients;

import menufact.plats.CreatorPlat;

public class ConcretCreatorViande extends CreatorIngredient {
    public Ingredient CreateMethod(String nom,String state)
    {
        return new Viande(nom,state);
    }
}
