package ingredients;

import ingredients.exceptions.IngredientException;

public class IngredientInventaire {
    private Ingredient ingredient;
    private double quantite;

    public IngredientInventaire(Ingredient ingredient, double quantite) throws IngredientException {
        this.ingredient = ingredient;
        this.setQuantite(quantite);
    }

    public Ingredient getIngredient()
    {
        return ingredient;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }
}
