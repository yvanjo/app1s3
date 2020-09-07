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
        Ingredient fruit = Fruit.getInstanceFruit("solide");
        Ingredient legume = Legume.getInstanceLegume("solide");
        Ingredient viande = Viande.getInstanceViande("solide");
        Ingredient laitier  = Laitier.getInstanceLaitier("liquide");
        Ingredient epice = Epice.getInstanceEpice("solide");

        Inventaire inventaireIngrediant = new Inventaire();

        IngredientInventaire inventaireFruit = new IngredientInventaire(fruit, 150);
        IngredientInventaire inventaireLegume = new IngredientInventaire(legume, 150);
        IngredientInventaire inventaireViande = new IngredientInventaire(viande, 150);
        IngredientInventaire inventaireEpice = new IngredientInventaire(epice, 150);
        IngredientInventaire inventaireLaitier = new IngredientInventaire(laitier, 150);

        inventaireIngrediant.ajouter(inventaireEpice);
        inventaireIngrediant.ajouter(inventaireViande);
        inventaireIngrediant.ajouter(inventaireFruit);
        inventaireIngrediant.ajouter(inventaireLegume);
        inventaireIngrediant.ajouter(inventaireLaitier);
        Inventaire CompositionP1 = new Inventaire();
        Inventaire CompositionP2 = new Inventaire();
        Inventaire CompositionP3 = new Inventaire();
        Inventaire CompositionP4 = new Inventaire();
        Inventaire CompositionP5 = new Inventaire();

        /*
        Création des inventaire des différent ingrédient dans un plat
         */
        //P1
        IngredientInventaire ingredientInventaireFruitP1 = new IngredientInventaire(fruit,170);
        IngredientInventaire ingredientInventaireViandeP1 = new IngredientInventaire(viande,170);
        IngredientInventaire ingredientInventaireLegumeP1 = new IngredientInventaire(legume,170);
        //p2
        IngredientInventaire ingredientInventaireFruitP2 = new IngredientInventaire(fruit,5);
        IngredientInventaire ingredientInventaireViandeP2 = new IngredientInventaire(viande,3);
        IngredientInventaire ingredientInventaireLaitierP2 = new IngredientInventaire(laitier,7);
        //p3
        IngredientInventaire ingredientInventaireEpicep3 = new IngredientInventaire(epice, 4);
        IngredientInventaire ingredientInventaireViandep3 = new IngredientInventaire(epice, 6);
        IngredientInventaire ingredientInventaireFruitp3 = new IngredientInventaire(epice, 3);
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

        CreatorPlat createurDePlatAuMenu = new platMenu();
        PlatAuMenu p1 = createurDePlatAuMenu.renderPlat(0,"PlatAuMenu0",10,CompositionP1);
        PlatAuMenu p2 = createurDePlatAuMenu.renderPlat(1,"PlatAuMenu1",20,CompositionP2);
        PlatAuMenu p3 = createurDePlatAuMenu.renderPlat(2,"PlatAuMenu2",30,CompositionP3);
        PlatAuMenu p4 = createurDePlatAuMenu.renderPlat(3,"PlatAuMenu3",40,CompositionP4);
        PlatAuMenu p5 = createurDePlatAuMenu.renderPlat(4,"PlatAuMenu4",50,CompositionP5);

        CreatorPlat createurDePlatSante = new platSanteCreate();

        PlatAuMenu ps1 = createurDePlatSante.renderPlat(10,"PlatSante0",10,11,11,11,CompositionP1);
        PlatAuMenu ps2 = createurDePlatSante.renderPlat(11,"PlatSante1",20,11,11,11,CompositionP2);
        PlatAuMenu ps3 = createurDePlatSante.renderPlat(12,"PlatSante2",30,11,11,11,CompositionP3);
        PlatAuMenu ps4 = createurDePlatSante.renderPlat(13,"PlatSante3",40,11,11,11,CompositionP4);
        PlatAuMenu ps5 = createurDePlatSante.renderPlat(14,"PlatSante4",50,11,11,11,CompositionP5);


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
