package menufact;

import Chef.Chef;
import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.*;

public class TestMenuFact01 {
    public static void main(String[] args) throws PlatException, IngredientException {
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



        PlatAuMenu p4 = createurDePlatAuMenu.createPlats(3,"PlatAuMenu3",40,CompositionP4);
        PlatAuMenu p5 = createurDePlatAuMenu.createPlats(4,"PlatAuMenu4",50,CompositionP5);

        platSanteCreate createurDePlatSante = new platSanteCreate();



        PlatAuMenu ps3 = createurDePlatSante.createPlats(12,"PlatSante2",30,11,11,11,CompositionP3);
        PlatAuMenu ps4 = createurDePlatSante.createPlats(13,"PlatSante3",40,11,11,11,CompositionP4);
        PlatAuMenu ps5 = createurDePlatSante.createPlats(14,"PlatSante4",50,11,11,11,CompositionP5);

        platEnfantCreate createurDePlatEnfant = new platEnfantCreate();

        PlatAuMenu pe1 = createurDePlatEnfant.createPlats(20,"chicken nuggets",10,0.25,CompositionP1);
        PlatAuMenu pe2 = createurDePlatEnfant.createPlats(21,"chicken nuggets",10,0.5,CompositionP2);
        PlatAuMenu pe3 = createurDePlatEnfant.createPlats(22,"chicken nuggets",10,0.75,CompositionP3);
        PlatAuMenu pe4 = createurDePlatEnfant.createPlats(23,"chicken nuggets",10,0.5,CompositionP4);
        PlatAuMenu pe5 = createurDePlatEnfant.createPlats(24,"chicken nuggets",10,0.25,CompositionP5);

        Menu m1 = new Menu("menufact.Menu 1");
        Menu m2 = new Menu("menufact.Menu 2");

        Chef chef = Chef.getInstance("Domingo", inventaireIngrediant);
        chef.Subscribe(m1);
        chef.Subscribe(m2);

        Facture f1 = new Facture("Ma facture", chef);

        Client c1 = new Client(1,"Mr Client","1234567890");
        try {
            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            PlatAuMenu p1 = createurDePlatAuMenu.createPlats(0,"Burger",10,CompositionP1);
            System.out.println(p1);

            System.out.println("===menufact.plats.PlatAuMenu Constructeur 3 arguments");
            PlatAuMenu p2 = createurDePlatAuMenu.createPlats(1,"Frite",20,CompositionP2);
            System.out.println(p2);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatAuMenu ps1 = createurDePlatSante.createPlats(10,"Salade",10,11,11,11,CompositionP1);
            System.out.println(ps1);

            System.out.println("===menufact.plats.PlatSante Constructeur 5 arguments");
            PlatAuMenu ps2 = createurDePlatSante.createPlats(11,"Salade cesar",20,11,11,11,CompositionP2);
            System.out.println(ps2);

            System.out.println("===menufact.Menu ajout avec 4 plats");
            Menu menu = new Menu("Menu1");
            menu.ajoute(p1);
            menu.ajoute(p2);
            menu.ajoute(ps1);
            menu.ajoute(ps2);
            System.out.println(menu);

            System.out.println("===menufact.Menu position 1, plat à la position 0");
            menu.position(0);
            System.out.println(menu.platCourant());

            System.out.println("===menufact.Menu position 1, plat à la position suivante 1");
            menu.positionSuivante();
            System.out.println(menu.platCourant());

            System.out.println("== Plat choisi");
            PlatChoisi pch1 = new PlatChoisi(p1, 5,p1.getComposition());
            System.out.println(pch1);

            System.out.println("== New menufact.facture.Facture");
            Facture facture = new Facture("Ma facture",chef);
            System.out.println(facture);

            System.out.println("== Ajout d'un plat choisie à la facture");
            facture.ajoutePlat(pch1);
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println("== Ajout d'un plat choisie à la facture");
            PlatChoisi pch2 = new PlatChoisi(p2, 10,p2.getComposition());
            facture.ajoutePlat(pch2);
            System.out.println(facture);
            System.out.println(facture.sousTotal());

            System.out.println(facture.total());
            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.fermer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.payer();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());

            facture.ouvrir();
            System.out.println(facture);
            System.out.println("Etat = " + facture.getEtat());
        }catch (Exception fe)
        {
            System.out.println(fe.getMessage());
        }

    }
}
