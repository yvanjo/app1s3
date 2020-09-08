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
        ConcretCreatorFruit fruit = new ConcretCreatorFruit();
        Ingredient fruit1 = fruit.CreateMethod("fruit 1", new StateSolide());
        ConcretCreatorViande viande = new ConcretCreatorViande();
        Ingredient viande1 = viande.CreateMethod("viande 1", new StateSolide());

        ConcretCreatorLegume legume = new ConcretCreatorLegume();
        Ingredient legume1 = legume.CreateMethod("legume 1", new StateSolide());
        ConcretCreatorLaitier laitier = new ConcretCreatorLaitier();
        Ingredient laitier1 = laitier.CreateMethod("laitier 1", new StateLiquide());
        ConcretCreatorFruit epice = new ConcretCreatorFruit();
        Ingredient epice1 = epice.CreateMethod("epice 1", new StateSolide());
        IngredientInventaire ingredientInventaireFruit = new IngredientInventaire(fruit1 ,134.00);
        IngredientInventaire ingredientInventaireViande = new IngredientInventaire(viande1 ,132344.60);
        IngredientInventaire ingredientInventaireLegume = new IngredientInventaire(legume1 ,123434.60);
        IngredientInventaire ingredientInventaireLaitier = new IngredientInventaire(laitier1 ,13234.60);
        IngredientInventaire ingredientInventaireEpice = new IngredientInventaire(epice1 ,234552344546.245);

        try
        {
           ingredientInventaireEpice.setQuantite(-124312);
        }
        catch(IngredientException IE)
        {
            System.out.println("not enough Ingredients");
        }

        try
        {
            ingredientInventaireFruit.setQuantite(-124312);
        }
        catch(IngredientException IE)
        {
            System.out.println("not enough Ingredients");
        }

        try
        {
            ingredientInventaireLaitier.setQuantite(-124312);
        }
        catch(IngredientException IE)
        {
            System.out.println("not enough Ingredients");
        }

        try
        {
            ingredientInventaireLegume.setQuantite(-124312);
        }
        catch(IngredientException IE)
        {
            System.out.println("not enough Ingredients");
        }

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

    public void test2() throws IngredientException {
        Boolean good = true;
        ConcretCreatorFruit fruit = new ConcretCreatorFruit();
        Ingredient fruit1 = fruit.CreateMethod("fruit 1", new StateSolide());
        Ingredient fruit2 = fruit.CreateMethod("fruit 2", new StateSolide());
        ConcretCreatorViande viande = new ConcretCreatorViande();
        Ingredient viande1 = viande.CreateMethod("viande 1", new StateSolide());
        Ingredient viande2 = viande.CreateMethod("viande 2", new StateSolide());
        ConcretCreatorLegume legume = new ConcretCreatorLegume();
        Ingredient legume1 = legume.CreateMethod("legume 1", new StateSolide());
        Ingredient legume2 = legume.CreateMethod("legume 2", new StateSolide());
        ConcretCreatorLaitier laitier = new ConcretCreatorLaitier();
        Ingredient laitier1 = laitier.CreateMethod("laitier 1", new StateLiquide());
        Ingredient laitier2 = laitier.CreateMethod("laitier 2", new StateLiquide());
        ConcretCreatorFruit epice = new ConcretCreatorFruit();
        Ingredient epice1 = epice.CreateMethod("epice 1", new StateSolide());
        Ingredient epice2 = epice.CreateMethod("epice 2", new StateSolide());

/*
        try
        {
            epice1.setStateIngredient( new StateLiquide());
            epice2.setStateIngredient( new StateSolide());
        }

        catch (IngredientException ie)
        {
           System.out.println("state can't be change");
        }
*/

        if(epice1.getState()==epice2.getState() ) {
            good = true;
        }

        if(fruit1.getState()==fruit2.getState()){
            good = true;
        }

        if(legume1.getState()!=legume2.getState())
        {
            good = true;
        }

        if(laitier1.getState()!=laitier2.getState()){
            good = true;
        }



        assertEquals(true,good);

    }


}