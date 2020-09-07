package ingredients;

import menufact.plats.CreatorPlat;

public class ConcretCreatorViande extends CreatorIngredient {
    public Ingredient CreateMethod(String nom,State state)
    {
        return new Viande(nom,state);
    }
}
