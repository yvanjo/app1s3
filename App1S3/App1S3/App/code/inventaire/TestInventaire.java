package inventaire;

import ingredients.*;
import ingredients.exceptions.IngredientException;

import static org.junit.Assert.*;
public class TestInventaire {
    @org.junit.Test
    /**
     * This test makes sure that we can add IngredientInventaire in Inventaire
     * (1) Instanciate ingredients
     * (2)Instanciate IngredientInventaire
     * (3)Add IngredientInventaire to Inventaire
     * (4) Check if we have the right size
     */
    public void Test1() throws IngredientException {
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
        Inventaire gardeManger = new Inventaire();

        gardeManger.ajouter(inventaireEpice1);
        gardeManger.ajouter(inventaireViande1);
        gardeManger.ajouter(inventaireFruit1);
        gardeManger.ajouter(inventaireLegume1);
        gardeManger.ajouter(inventaireLaitier1);
        gardeManger.ajouter(inventaireEpice2);
        gardeManger.ajouter(inventaireViande2);
        gardeManger.ajouter(inventaireFruit2);
        gardeManger.ajouter(inventaireLegume2);
        gardeManger.ajouter(inventaireLaitier2);
        /**
         * (4)
         */
        assertEquals(10,gardeManger.getCount());
    }

    @org.junit.Test
    /**
     * This test make sure that we can access the inventory
     * (1) Instanciate ingredients
     * (2)Instanciate IngredientInventaire
     * (3)Add IngredientInventaire to Inventaire
     * (4) Check if we access the right data
     */
    public void Test2() throws IngredientException {
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

        Inventaire gardeManger = new Inventaire();
        /**
         * (3)
          */
        gardeManger.ajouter(inventaireEpice1);
        gardeManger.ajouter(inventaireViande1);
        gardeManger.ajouter(inventaireFruit1);
        gardeManger.ajouter(inventaireLegume1);
        gardeManger.ajouter(inventaireLaitier1);
        gardeManger.ajouter(inventaireEpice2);
        gardeManger.ajouter(inventaireViande2);
        gardeManger.ajouter(inventaireFruit2);
        gardeManger.ajouter(inventaireLegume2);
        gardeManger.ajouter(inventaireLaitier2);
        /**
         * (4)
         */
        assertEquals(inventaireEpice1,gardeManger.getElementInventaire(0));
    }


}
