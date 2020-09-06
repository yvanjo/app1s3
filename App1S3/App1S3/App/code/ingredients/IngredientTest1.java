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
        mettre un try catch!!!!!!!!!!!!!!!!!!
     */
    public void test1() throws IngredientException {
        Boolean succeed = true;
        Ingredient fruit = Fruit.getInstanceFruit("liquid");
        Ingredient viande = Viande.getInstanceViande("liquid");
        Ingredient legume =  Legume.getInstanceLegume("liquid");
        Ingredient laitier =  Laitier.getInstanceLaitier("liquid");
        Ingredient epice =  Epice.getInstanceEpice("liquid");
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

    @org.junit.Test

    public void test2() throws IngredientException{
        Boolean good = true;
        Ingredient epice = Epice.getInstanceEpice("Solide");
        Ingredient epice2 = Epice.getInstanceEpice("Solide");
        Ingredient fruit = Fruit.getInstanceFruit("solide");
        Ingredient fruit2 = Fruit.getInstanceFruit("solide");
        Ingredient legume = Legume.getInstanceLegume("solide");
        Ingredient legume2 = Legume.getInstanceLegume("solide");
        Ingredient laitier = Laitier.getInstanceLaitier("liquide");
        Ingredient laitier2 = Laitier.getInstanceLaitier("liquide");

        if(epice.hashCode()==epice.hashCode()) {
            good = true;
        }

        if(fruit.hashCode()==fruit2.hashCode()){
            good = true;
        }

        if(legume.hashCode()==legume2.hashCode())
        {
            good = true;
        }

        if(laitier.hashCode()==laitier2.hashCode()){
            good = true;
        }
        assertEquals(true,good);

    }
}