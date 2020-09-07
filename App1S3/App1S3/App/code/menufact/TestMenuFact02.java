package menufact;

import Chef.Chef;
import Chef.ChefException;
import ingredients.*;
import ingredients.exceptions.IngredientException;
import menufact.facture.exceptions.FactureException;
import menufact.exceptions.MenuException;
import menufact.facture.Facture;
import menufact.plats.*;
import inventaire.Inventaire;

public class TestMenuFact02 {

    public static void main(String[] args) throws IngredientException, FactureException {
        boolean trace = true;

        TestMenuFact02 t = new TestMenuFact02();
        /*
        Création des instances des différents ingrédients
        */
        CreatorIngredient godOfIngredientsEpice = new ConcretCreatorEpice();
        CreatorIngredient godOfIngredientsFruit = new ConcretCreatorFruit();
        CreatorIngredient godOfIngredientsLegume = new ConcretCreatorLegume();
        CreatorIngredient godOfIngredientsLaitier = new ConcretCreatorLaitier();
        CreatorIngredient godOfIngredientsViande = new ConcretCreatorViande();
        Ingredient fruit1 = godOfIngredientsFruit.CreateMethod("Orange","solid");
        Ingredient fruit2 = godOfIngredientsFruit.CreateMethod("Jus","liquid");
        Ingredient epice1 = godOfIngredientsEpice.CreateMethod("Paprika","liquid");
        Ingredient epice2 = godOfIngredientsEpice.CreateMethod("JusEpice","solid");
        Ingredient viande1 = godOfIngredientsViande.CreateMethod("Steak","solid");
        Ingredient viande2 = godOfIngredientsViande.CreateMethod("Jambon","solid");
        Ingredient laitier1  = godOfIngredientsLaitier.CreateMethod("Lait","liquid");
        Ingredient laitier2  = godOfIngredientsLaitier.CreateMethod("Fromage","solid");
        Ingredient legume1 = godOfIngredientsLegume.CreateMethod("Carrot","solid");
        Ingredient legume2 = godOfIngredientsLegume.CreateMethod("Jus","liquid");

        /*
            création de l'inventaire des ingredients dans le restaurant
         */
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
        chef.Subscribe(m1);
        chef.Subscribe(m2);

        Facture f1 = new Facture("Ma facture", chef);

        Client c1 = new Client(1,"Mr Client","1234567890");


        t.test1_AffichePlatsAuMenu(trace, p1,p2,p3,p4,p5);
        t.test2_AffichePlatsSante(trace, ps1,ps2,ps3,ps4,ps5);

        t.test4_AjoutPlatsAuMenu(trace, m1, p1, p2, ps1, ps2, m2, p3, p4, ps3, ps4);


        try {
            t.test5_DeplacementMenuAvancer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test6_DeplacementMenuReculer(m1);
        } catch (MenuException e) {
            System.out.println(e.getMessage());
        }

        try {
            t.test7_CreerFacture(f1, m1);
        } catch (FactureException | IngredientException | ChefException e) {
            System.out.println(e.getMessage());
        }


        t.test8_AjouterClientFacture(f1, c1);

        try {
            t.test8_AjouterPlatsFacture(f1, m1,1);
        } catch (FactureException | IngredientException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        } catch (ChefException e) {
            System.out.println(e);
        }

        t.test9_PayerFacture(f1);

        try {
            t.test8_AjouterPlatsFacture(f1, m1,1);
        } catch (FactureException | IngredientException | ChefException fe)
        {
            System.out.println(fe.getMessage());
        }
        catch (MenuException me)
        {
            System.out.println(me);
        }

        try {
            f1.ouvrir();
        } catch (FactureException fe)
        {
            System.out.println(fe.getMessage());
        }






        System.out.println("FIN DE TOUS LES TESTS...");

        System.out.println(f1.genererFacture());
    }

    private void test1_AffichePlatsAuMenu(boolean trace, PlatAuMenu p1, PlatAuMenu p2,
                                          PlatAuMenu p3, PlatAuMenu p4, PlatAuMenu p5)
    {
        System.out.println("=== test1_AffichePlatsAuMenu");
        if(trace)
        {
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
            System.out.println(p5);
        }
    }


   private void test2_AffichePlatsSante(boolean trace, PlatAuMenu ps1, PlatAuMenu ps2,
                                        PlatAuMenu ps3, PlatAuMenu ps4, PlatAuMenu ps5)
    {
        System.out.println("=== test2_AffichePlatsSante");

        if(trace)
        {
            System.out.println(ps1);
            System.out.println(ps2);
            System.out.println(ps3);
            System.out.println(ps4);
            System.out.println(ps5);
        }
    }


    private static void test3_AjoutMenu(boolean trace, Menu m1, Menu m2)
    {

        System.out.println("=== test3_AjoutMenu");

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test4_AjoutPlatsAuMenu(boolean trace, Menu m1,
                                        PlatAuMenu p1, PlatAuMenu p2,
                                        PlatAuMenu ps1, PlatAuMenu ps2,
                                        Menu m2,
                                        PlatAuMenu p3, PlatAuMenu p4,
                                        PlatAuMenu ps3, PlatAuMenu ps4)
    {
        System.out.println("=== test4_AjoutPlatsAuMenu");
        System.out.println("=== Ajout de plats au menu 1");
        m1.ajoute(p1);
        m1.ajoute(p2);
        m1.ajoute(ps1);
        m1.ajoute(ps2);


        System.out.println("=== Ajout de plats au menu 2");
        m2.ajoute(p3);
        m2.ajoute(p4);
        m2.ajoute(ps3);
        m2.ajoute(ps4);

        if(trace) {
            System.out.println(m1);
            System.out.println(m2);
        }
    }


    private void test5_DeplacementMenuAvancer(Menu m1) throws MenuException
    {
        System.out.println("=== test5_DeplacementMenuAvancer");

        System.out.println("===Selectionner un plat du menu 0");
        m1.position(0);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Avancer le plat courant");
            System.out.println("1.");
            m1.positionSuivante();
            System.out.println("2.");
            m1.positionSuivante();
            System.out.println("3.");
            m1.positionSuivante();
            System.out.println("4.");
            m1.positionSuivante();
            System.out.println("5.");
            m1.positionSuivante();
        }
        catch (MenuException me)
        {
                throw me;
        }
    }


    private void test6_DeplacementMenuReculer(Menu m1) throws MenuException
    {
        System.out.println("===test6_DeplacementMenuReculer");

        System.out.println("===Selectionner un plat du menu 3");
        m1.position(3);

        System.out.println("=== Afficher le plat courant");
        System.out.println(m1.platCourant());
        try {

            System.out.println("=== Reculer le plat courant");
            System.out.println("2.");
            m1.positionPrecedente();
            System.out.println("1.");
            m1.positionPrecedente();
            System.out.println("0.");
            m1.positionPrecedente();
            System.out.println("-1.");
            m1.positionPrecedente();
            System.out.println("-2.");
            m1.positionPrecedente();
        }
        catch (MenuException me)
        {
            throw me;
        }
    }

    private void test7_CreerFacture(Facture f1, Menu m1) throws FactureException, IngredientException, ChefException {
        System.out.println("===test7_CreerFacture");

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5,m1.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }


    private void test8_AjouterClientFacture(Facture f1,Client c1) throws FactureException {
        System.out.println("===test8_AjouterClientFacture");
        f1.associerClient(c1);
        System.out.println(f1);
    }
    private void test8_AjouterPlatsFacture(Facture f1, Menu m1, int pos) throws MenuException, FactureException, IngredientException, ChefException {
        System.out.println("===test8_AjouterPlatsFacture");

        try{
            for (int i=0; i< pos; i++)
                m1.positionSuivante();
        }
        catch (MenuException me)
        {
            throw me;
        }

        PlatChoisi platChoisi = new PlatChoisi(m1.platCourant(),5,m1.platCourant().getComposition());
        try
        {
            f1.ajoutePlat(platChoisi);
        }
        catch (FactureException | IngredientException | ChefException fe)
        {
            throw fe;
        }
        System.out.println(f1);
    }

    private void test9_PayerFacture(Facture f1)
    {
        System.out.println("===test9_PayerFacture");

        System.out.println("Avant payer la facture");
        System.out.println(f1);
        f1.payer();
        System.out.println("Apres avoir paye la facture");
        System.out.println(f1);
    }
}
