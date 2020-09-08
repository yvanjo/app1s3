package menufact.plats;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import org.junit.Assert;
import menufact.exceptions.MenuException;

import static org.junit.Assert.*;


public class PlatTest {

    @org.junit.Test
    /*
    Factory des plats
     */
    public void test1() throws IngredientException, PlatException {
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

        Inventaire CompositionP1 = new Inventaire();
        Inventaire CompositionP2 = new Inventaire();
        Inventaire CompositionP3 = new Inventaire();
        Inventaire CompositionP4 = new Inventaire();
        Inventaire CompositionP5 = new Inventaire();

        /*
        Création des inventaire des différent ingrédient dans un plat
         */
        //P1
        IngredientInventaire ingredientInventaireFruitP1 = new IngredientInventaire(fruit1,6);
        IngredientInventaire ingredientInventaireViandeP1 = new IngredientInventaire(viande2,6);
        IngredientInventaire ingredientInventaireLegumeP1 = new IngredientInventaire(legume1,6);
        //p2
        IngredientInventaire ingredientInventaireFruitP2 = new IngredientInventaire(fruit2,1);
        IngredientInventaire ingredientInventaireViandeP2 = new IngredientInventaire(viande1,1);
        IngredientInventaire ingredientInventaireLaitierP2 = new IngredientInventaire(laitier2,1);
        //p3
        IngredientInventaire ingredientInventaireEpicep3 = new IngredientInventaire(epice2, 2);
        IngredientInventaire ingredientInventaireViandep3 = new IngredientInventaire(epice1, 2);
        IngredientInventaire ingredientInventaireFruitp3 = new IngredientInventaire(laitier2, 2);
        //ajout de l'inventaire à la composition
        //p1
        CompositionP1.ajouter(ingredientInventaireFruitP1);
        CompositionP1.ajouter(ingredientInventaireLegumeP1);
        CompositionP1.ajouter(ingredientInventaireViandeP1);
        //p2
        CompositionP2.ajouter(ingredientInventaireFruitP2);
        CompositionP2.ajouter(ingredientInventaireViandeP2);
        CompositionP2.ajouter(ingredientInventaireLaitierP2);
        //p3
        CompositionP3.ajouter(ingredientInventaireEpicep3);
        CompositionP3.ajouter(ingredientInventaireViandep3);
        CompositionP3.ajouter(ingredientInventaireFruitp3);
        //p4
        CompositionP4.ajouter(ingredientInventaireEpicep3);
        CompositionP4.ajouter(ingredientInventaireViandep3);
        CompositionP4.ajouter(ingredientInventaireFruitp3);
        //p5
        CompositionP5.ajouter(ingredientInventaireEpicep3);
        CompositionP5.ajouter(ingredientInventaireViandep3);
        CompositionP5.ajouter(ingredientInventaireFruitp3);

        platMenuCreate createurDePlatAuMenu = new platMenuCreate();

        try{
            PlatAuMenu p1 = createurDePlatAuMenu.createPlats(0, "PlatAuMenu0", -10, CompositionP1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu p2 = createurDePlatAuMenu.createPlats(-1, "PlatAuMenu1", 20, CompositionP2);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu p3 = createurDePlatAuMenu.createPlats(2, "PlatAuMenu2", -30, CompositionP3);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu p4 = createurDePlatAuMenu.createPlats(-3, "PlatAuMenu3", -40, CompositionP4);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        PlatAuMenu p5 = createurDePlatAuMenu.createPlats(4, "PlatAuMenu4", 50, CompositionP5);

        platSanteCreate createurDePlatSante = new platSanteCreate();
        try
        {
            PlatAuMenu ps1 = createurDePlatSante.createPlats(-10, "PlatSante0", -10, -11, -11, -11, CompositionP1);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu ps2 = createurDePlatSante.createPlats(11, "PlatSante1", 20, 11, 11, -11, CompositionP2);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu ps3 = createurDePlatSante.createPlats(12, "PlatSante2", 30, 11, -11, 11, CompositionP3);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu ps4 = createurDePlatSante.createPlats(13, "PlatSante3", 40, -11, 11, 11, CompositionP4);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu ps5 = createurDePlatSante.createPlats(14, "PlatSante4", -50, 11, 11, 11, CompositionP5);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }

        platEnfantCreate createurDePlatEnfant = new platEnfantCreate();

        try
        {
            PlatAuMenu pe1 = createurDePlatEnfant.createPlats(20,"chicken nuggets",10,-0.25,CompositionP1);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu pe2 = createurDePlatEnfant.createPlats(20,"chicken nuggets",10,-0.5, CompositionP2);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu pe3 = createurDePlatEnfant.createPlats(20,"chicken nuggets",-10,0.75,CompositionP3);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu pe4 = createurDePlatEnfant.createPlats(20,"chicken nuggets",10,0.5,CompositionP4);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
        try
        {
            PlatAuMenu pe5 = createurDePlatEnfant.createPlats(20,"chicken nuggets",10,0.25,CompositionP5);
        }
        catch(PlatException e)
        {
            System.out.println(e);
        }
    }


}
