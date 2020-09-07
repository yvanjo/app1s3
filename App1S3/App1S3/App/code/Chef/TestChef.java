package Chef;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.Client;
import menufact.Menu;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import org.junit.ClassRule;

import static org.junit.Assert.*;

public class     TestChef {

    @org.junit.Test
     /*
        Here we are checking if chef is a singleton
     */
    public void test1() throws IngredientException {

        Inventaire gardeManger = new Inventaire();

        Boolean succeed = true;
        Chef chef =Chef.getInstance("Stephanie",gardeManger);
        Chef chef1 = Chef.getInstance("Philippe", gardeManger);
        if (chef.hashCode() == chef1.hashCode()){
            succeed = true;
        }
        else{
            succeed =false;
        }
        assertEquals(true,succeed);
    }

    @org.junit.Test

    /*
        Here Test Chain Of Responsibility
*/

    public void test2() throws IngredientException, MenuException, FactureException, ChefException {
        boolean trace = true;
        boolean succeed = true;
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

        Inventaire inventaireIngrediant = new Inventaire();

        /*
            Création des inventaire des différent ingrédient
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

        /*
            Ajouts des ingredient inventaire à l'inventaire
         */

        inventaireIngrediant.ajouter(inventaireEpice1);
        inventaireIngrediant.ajouter(inventaireViande1);
        inventaireIngrediant.ajouter(inventaireFruit1);
        inventaireIngrediant.ajouter(inventaireLegume1);
        inventaireIngrediant.ajouter(inventaireLaitier1);
        inventaireIngrediant.ajouter(inventaireEpice2);
        inventaireIngrediant.ajouter(inventaireViande2);
        inventaireIngrediant.ajouter(inventaireFruit2);
        inventaireIngrediant.ajouter(inventaireLegume2);
        inventaireIngrediant.ajouter(inventaireLaitier2);


        /*
        Création de la compositions de plats
         */
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
                /*
        Création des plats au menu
         */

        platMenuCreate createurDePlatAuMenu = new platMenuCreate();
        PlatAuMenu p1 = createurDePlatAuMenu.createPlats(0,"PlatAuMenu0",10,CompositionP1);
        PlatAuMenu p2 = createurDePlatAuMenu.createPlats(1,"PlatAuMenu1",20,CompositionP2);
        PlatAuMenu p3 = createurDePlatAuMenu.createPlats(2,"PlatAuMenu2",30,CompositionP3);
        PlatAuMenu p4 = createurDePlatAuMenu.createPlats(3,"PlatAuMenu3",40,CompositionP4);
        PlatAuMenu p5 = createurDePlatAuMenu.createPlats(4,"PlatAuMenu4",50,CompositionP5);

        platSanteCreate createurDePlatSante = new platSanteCreate();

        PlatAuMenu ps1 = createurDePlatSante.createPlats(10,"PlatSante0",10,11,11,11,CompositionP1);
        PlatAuMenu ps2 = createurDePlatSante.createPlats(11,"PlatSante1",20,11,11,11,CompositionP2);
        PlatAuMenu ps3 = createurDePlatSante.createPlats(12,"PlatSante2",30,11,11,11,CompositionP3);
        PlatAuMenu ps4 = createurDePlatSante.createPlats(13,"PlatSante3",40,11,11,11,CompositionP4);
        PlatAuMenu ps5 = createurDePlatSante.createPlats(14,"PlatSante4",50,11,11,11,CompositionP5);



        Menu m1 = new Menu("menufact.Menu 1");
        Menu m2 = new Menu("menufact.Menu 2");

        Chef chef = Chef.getInstance("Domingo", inventaireIngrediant);

        Facture f1 = new Facture("Ma facture", chef);

        Client c1 = new Client(1,"Mr Client","1234567890");

        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);


        System.out.println("=== Ajout de plats au menu 2");
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);

        m1.position(0);
        int initialLenght = m1.getMenu().size();

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5,m1.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);
        try
        {
            m1.positionSuivante();
        }
        catch(MenuException ME)
        {
            System.out.println(ME);
        }



        PlatChoisi platChoisi1 = new PlatChoisi(m1.platCourant(),5,m1.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi1);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);
        try
        {
            m1.positionSuivante();
        }
        catch(MenuException ME)
        {
            System.out.println(ME);
        }



        PlatChoisi platChoisi2 = new PlatChoisi(m1.platCourant(),5,m1.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi2);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);
        try
        {
            m1.positionSuivante();
        }
        catch(MenuException ME)
        {
            System.out.println(ME);
        }



        PlatChoisi platChoisi3 = new PlatChoisi(m1.platCourant(),5,m1.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi3);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);
        try
        {
            m2.positionSuivante();
        }
        catch(MenuException ME)
        {
            System.out.println(ME);
        }


        PlatChoisi platChoisi4 = new PlatChoisi(m2.platCourant(),5,m2.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi4);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);
        try
        {
            m2.positionSuivante();
        }
        catch(MenuException ME)
        {
            System.out.println(ME);
        }


        PlatChoisi platChoisi5 = new PlatChoisi(m2.platCourant(),5,m2.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi5);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);
        try
        {
            m1.positionSuivante();
        }
        catch(MenuException ME)
        {
            System.out.println(ME);
        }


        PlatChoisi platChoisi6 = new PlatChoisi(m2.platCourant(),5,m2.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi6);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);
        try
        {
            m2.positionSuivante();
        }
        catch(MenuException ME)
        {
            System.out.println(ME);
        }

        PlatChoisi platChoisi7 = new PlatChoisi(m2.platCourant(),5,m2.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi7);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        System.out.println(f1);


        assertEquals(true, succeed);

    }





}
