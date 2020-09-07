package ingredients;

import menufact.plats.CreatorPlat;

public class ConcretCreatorEpice extends CreatorIngredient {
    public Ingredient CreateMethod(String nom,String state)
    {
        return new Epice(nom,state);
    }
}
