package inventaire;

import ingredients.Ingredient;
import ingredients.IngredientInventaire;

import java.util.ArrayList;

public class Inventaire {
    private ArrayList<IngredientInventaire> ingredientsInventaires = new ArrayList<>();
    private int count =0;
    public void ajouter (IngredientInventaire ingredientInventaire)
    {
        ingredientsInventaires.add(ingredientInventaire);
        count = count+1;
    }

    public int getCount()
    {
        return count;
    }

    public IngredientInventaire getElementInventaire(int i)
    {
        return ingredientsInventaires.get(i);
    }

}
