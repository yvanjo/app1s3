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
        this test is extremely long because it needs to load a lot of stuff
*/

    public void test2() throws IngredientException, MenuException, FactureException, ChefException, PlatException {
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
        IngredientInventaire ingredientInventaireFruitP1 = new IngredientInventaire(fruit1,170);
        IngredientInventaire ingredientInventaireViandeP1 = new IngredientInventaire(viande2,170);
        IngredientInventaire ingredientInventaireLegumeP1 = new IngredientInventaire(legume1,170);
        //p2
        IngredientInventaire ingredientInventaireFruitP2 = new IngredientInventaire(fruit2,5);
        IngredientInventaire ingredientInventaireViandeP2 = new IngredientInventaire(viande1,13);
        IngredientInventaire ingredientInventaireLaitierP2 = new IngredientInventaire(laitier2,10);
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
        PlatAuMenu p1 = createurDePlatAuMenu.createPlats(0,"PlatAuMenu1",10,CompositionP1);
        PlatAuMenu p2 = createurDePlatAuMenu.createPlats(1,"PlatAuMenu2",20,CompositionP2);
        PlatAuMenu p3 = createurDePlatAuMenu.createPlats(2,"PlatAuMenu3",30,CompositionP3);
        PlatAuMenu p4 = createurDePlatAuMenu.createPlats(3,"PlatAuMenu4",40,CompositionP4);
        PlatAuMenu p5 = createurDePlatAuMenu.createPlats(4,"PlatAuMenu5",50,CompositionP5);


        Chef chef = Chef.getInstance("Domingo", inventaireIngrediant);

        Facture f1 = new Facture("Ma facture", chef);

        PlatChoisi platChoisi = new PlatChoisi(p1,5,p1.getComposition());
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");
        }
        if(f1.getPlatChoisi().contains(platChoisi))
        {
            succeed = false;
        }



        PlatChoisi platChoisi1 = new PlatChoisi(p2,5,p2.getComposition());
        try
        {
            f1.ajoutePlat(platChoisi1);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");

        }
        if(!f1.getPlatChoisi().contains(platChoisi1))
        {
            succeed = false;
        }



        PlatChoisi platChoisi2 = new PlatChoisi(p3,5,p3.getComposition());
        try
        {
            f1.ajoutePlat(platChoisi2);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");

        }
        if(!f1.getPlatChoisi().contains(platChoisi2))
        {
            succeed =false;
        }



        PlatChoisi platChoisi3 = new PlatChoisi(p4,5,p4.getComposition());
        try
        {
            f1.ajoutePlat(platChoisi3);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");

        }
        if(!f1.getPlatChoisi().contains(platChoisi3))
        {
            succeed = false;
        }


        PlatChoisi platChoisi4 = new PlatChoisi(p5,5,p5.getComposition());
        try
        {
            f1.ajoutePlat(platChoisi4);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println("not enough ingredients");

        }
        if(!f1.getPlatChoisi().contains(platChoisi4))
        {
            succeed = false;
        }


        assertEquals(true, succeed);
    }
    @org.junit.Test
    /*
    Subscribe
     */
    public void Test3() throws PlatException {
        Boolean succeed =true;
        Inventaire Composition =new Inventaire();
        Inventaire GardeManger = new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        Menu m1 = new Menu("un menu");
        m1.ajoute(monPlatAuMenu);
        Chef chef = Chef.getInstance("Stephanie",GardeManger);
        chef.Subscribe(m1);
        assertEquals(1,chef.getSubscribers().size());

    }
    @org.junit.Test
    /*
    Subscribe
     */
    public void Test4() throws PlatException {
        Boolean succeed =true;
        Inventaire Composition =new Inventaire();
        Inventaire GardeManger = new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        Menu m1 = new Menu("un menu");
        m1.ajoute(monPlatAuMenu);
        Chef chef = Chef.getInstance("Stephanie",GardeManger);
        chef.Subscribe(m1);
        chef.UnSubscribe(m1);
        assertEquals(0,chef.getSubscribers().size());

    }
    @org.junit.Test
    /*
        Test Observer
     */
    public void Test5() throws PlatException {
        Boolean succeed =true;
        Inventaire Composition =new Inventaire();
        Inventaire GardeManger = new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        Menu m1 = new Menu("un menu");
        m1.ajoute(monPlatAuMenu);
        Chef chef = Chef.getInstance("Stephanie",GardeManger);
        chef.Subscribe(m1);
        chef.notifier(monPlatAuMenu);
        assertEquals(0,m1.getMenu().size());

    }
}
