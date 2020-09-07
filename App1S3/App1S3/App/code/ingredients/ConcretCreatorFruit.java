package ingredients;

import menufact.plats.CreatorPlat;

public class ConcretCreatorFruit extends CreatorIngredient {
    public Ingredient CreateMethod(String nom,String state)
    {
        return new Fruit(nom,state);
    }
}
