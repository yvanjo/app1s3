package ingredients;

import static org.junit.Assert.*;
import ingredients.exceptions.IngredientException;

public class TestIngredient {
    @org.junit.Test
    /**
     * this test checks if the factory method works.
     * (1) it loads it creats different ingredients via some concret creators
     * (2) it puts them in an inventory of ingredients
     *(3) it checks if the ingredients in it is the same as the instance of the ingredient
     */
    public void Test1() throws IngredientException {
        Boolean succeed = true;
        /**
         * (1)
         */
        CreatorIngredient godOfIngredientsEpice = new ConcretCreatorEpice();
        CreatorIngredient godOfIngredientsFruit = new ConcretCreatorFruit();
        CreatorIngredient godOfIngredientsLegume = new ConcretCreatorLegume();
        CreatorIngredient godOfIngredientsLaitier = new ConcretCreatorLaitier();
        CreatorIngredient godOfIngredientsViande = new ConcretCreatorViande();
        Ingredient fruit1 = godOfIngredientsFruit.CreateMethod("Orange",new StateSolide());
        Ingredient fruit2 = godOfIngredientsFruit.CreateMethod("Jus",new StateLiquide());
        Ingredient epice1 = godOfIngredientsEpice.CreateMethod("Paprika",new StateLiquide());
        Ingredient epice2 = godOfIngredientsEpice.CreateMethod("JusEpice",new StateLiquide());
        Ingredient viande1 = godOfIngredientsViande.CreateMethod("Steak",new StateSolide());
        Ingredient viande2 = godOfIngredientsViande.CreateMethod("Jambon",new StateSolide());
        Ingredient laitier1  = godOfIngredientsLaitier.CreateMethod("Lait",new StateLiquide());
        Ingredient laitier2  = godOfIngredientsLaitier.CreateMethod("Fromage",new StateSolide());
        Ingredient legume1 = godOfIngredientsLegume.CreateMethod("Carrot",new StateSolide());
        Ingredient legume2 = godOfIngredientsLegume.CreateMethod("Jus",new StateLiquide());

        /**
         * (2)
         */
        IngredientInventaire inventaireFruit1 = new IngredientInventaire(fruit1, 150);
        IngredientInventaire inventaireLegume1 = new IngredientInventaire(legume1, 150);
        IngredientInventaire inventaireViande1 = new IngredientInventaire(viande1, 150);
        IngredientInventaire inventaireEpice1 = new IngredientInventaire(epice1, 150);
        IngredientInventaire inventaireLaitier1 = new IngredientInventaire(laitier1, 150);
        IngredientInventaire inventaireFruit2 = new IngredientInventaire(fruit2, 150);
        IngredientInventaire inventaireLegume2 = new IngredientInventaire(legume2, 150);
        IngredientInventaire inventaireViande2 = new IngredientInventaire(viande2, 150);
        IngredientInventaire inventaireEpice2 = new IngredientInventaire(epice2, 150);
        IngredientInventaire inventaireLaitier2 = new IngredientInventaire(laitier2, 150);

        /**
         * (3)
         */
        if(inventaireFruit1.getIngredient().hashCode() != fruit1.hashCode())
        {
            succeed = false;
        }
        if(inventaireFruit2.getIngredient().hashCode() != fruit2.hashCode())
        {
            succeed = false;
        }
        if(inventaireLegume1.getIngredient().hashCode() != legume1.hashCode())
        {
            succeed = false;
        }
        if(inventaireLegume2.getIngredient().hashCode() != legume2.hashCode())
        {
            succeed = false;
        }
        if(inventaireViande1.getIngredient().hashCode() != viande1.hashCode())
        {
            succeed = false;
        }
        if(inventaireViande2.getIngredient().hashCode() != viande2.hashCode())
        {
            succeed = false;
        }
        if(inventaireEpice1.getIngredient().hashCode() != epice1.hashCode())
        {
            succeed = false;
        }
        if(inventaireEpice2.getIngredient().hashCode() != epice2.hashCode())
        {
            succeed = false;
        }
        if(inventaireLaitier1.getIngredient().hashCode() != laitier1.hashCode())
        {
            succeed = false;
        }
        if(inventaireLaitier2.getIngredient().hashCode() != laitier2.hashCode())
        {
            succeed = false;
        }
        assertEquals(true,succeed);
    }

        @org.junit.Test
/**
 *
 */
        public void Test2()
        {
            CreatorIngredient godOfIngredientsEpice = new ConcretCreatorEpice();
            Ingredient epice1 = godOfIngredientsEpice.CreateMethod("Paprika",new StateLiquide());

            epice1.setStateIngredient(new StateSolide());
            assertEquals(new StateLiquide().getClass(),epice1.getState().getClass());

        }

        @org.junit.Test
        /*
        Changement unite
         */
        public void Test3()
        {
            CreatorIngredient godOfIngredientsEpice = new ConcretCreatorEpice();
            Ingredient epice1 = godOfIngredientsEpice.CreateMethod("Paprika",new StateLiquide());
            assertEquals(TypeUnite.ML,epice1.getUnite());
        }

    @org.junit.Test
    /*
    verifier que l'on ne peut pas avoir de quantité negative dans les ingredients inventaire
     */
    public void Test4() throws IngredientException {
        boolean succes = true;
        CreatorIngredient godOfIngredientsEpice = new ConcretCreatorEpice();
        Ingredient epice1 = godOfIngredientsEpice.CreateMethod("Paprika",new StateLiquide());
        IngredientInventaire inventaireEpice1 = new IngredientInventaire(epice1, 150);

        try
        {
            inventaireEpice1.setQuantite(-1);
        }
        catch(IngredientException ie)
        {
            System.out.println(ie);
        }
        if(inventaireEpice1.getQuantite()<0)
        {
            succes = false;
        }
        assertEquals(true,succes);
    }
}
