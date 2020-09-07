package ingredients;

import menufact.plats.CreatorPlat;

public class ConcretCreatorLegume extends CreatorIngredient {
    public Ingredient CreateMethod(String nom,State state)
    {
        return new Legume(nom, state);
    }
}
