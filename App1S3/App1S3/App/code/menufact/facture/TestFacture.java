package menufact.facture;

import Chef.Chef;
import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;

import static org.junit.Assert.*;

public class TestFacture {
    @org.junit.Test
    public void Test1() throws IngredientException {
        Ingredient fruit = new Fruit("solide");
        Ingredient legume = new Legume("solide");
        Ingredient viande = new Viande("solide");
        Ingredient laitier  = new Laitier("liquide");
        Ingredient epice = new Epice("solide");

        Inventaire inventaireIngrediant = new Inventaire();

        IngredientInventaire inventaireFruit = new IngredientInventaire(fruit, 5);
        IngredientInventaire inventaireLegume = new IngredientInventaire(legume, 5);
        IngredientInventaire inventaireViande = new IngredientInventaire(viande, 5);
        IngredientInventaire inventaireEpice = new IngredientInventaire(epice, 5);
        IngredientInventaire inventaireLaitier = new IngredientInventaire(laitier, 5);



    }
}
