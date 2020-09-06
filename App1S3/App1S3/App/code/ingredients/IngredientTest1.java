package ingredients;

import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import org.junit.Assert;

import static org.junit.Assert.*;

public class IngredientTest1 {

    @org.junit.Test
    /*
        Test de validation des quantitées
        il faut s'assurer que toute les méthodes peuvent acceder à leur quantité
     */
    public void test1() throws IngredientException {
        Boolean succeed = true;
        Ingredient fruit = new Fruit("liquid");
        Ingredient viande = new Viande("liquid");
        Ingredient legume = new Legume("liquid");
        Ingredient laitier = new Laitier("liquid");
        Ingredient epice = new Epice("liquid");
        IngredientInventaire ingredientInventaireFruit = new IngredientInventaire(fruit ,134.00);
        IngredientInventaire ingredientInventaireViande = new IngredientInventaire(viande ,132344.60);
        IngredientInventaire ingredientInventaireLegume = new IngredientInventaire(legume ,123434.60);
        IngredientInventaire ingredientInventaireLaitier = new IngredientInventaire(laitier ,13234.60);
        IngredientInventaire ingredientInventaireEpice = new IngredientInventaire(epice ,234552344546.245);
        if(ingredientInventaireFruit.getQuantite() <=0 && succeed)
        {
            succeed =false;
        }
        if(ingredientInventaireViande.getQuantite() <=0  && succeed){
            succeed = false;
        }
        if(ingredientInventaireLegume.getQuantite() <=0 && succeed){
            succeed = false;
        }

        if(ingredientInventaireLaitier.getQuantite() <=0 && succeed){
            succeed = false;
        }
        if(ingredientInventaireEpice.getQuantite() <=0 && succeed){
            succeed = false;
        }
        assertEquals(true ,succeed);
    }


}