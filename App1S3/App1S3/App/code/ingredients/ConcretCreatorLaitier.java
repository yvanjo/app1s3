package ingredients;

import menufact.plats.CreatorPlat;

public class ConcretCreatorLaitier extends CreatorIngredient {
    public Ingredient CreateMethod(String nom,State state)
    {
        return new Laitier(nom,state);
    }
}
