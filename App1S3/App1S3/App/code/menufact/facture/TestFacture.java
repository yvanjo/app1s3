package menufact.facture;

import Chef.Chef;
import Chef.ChefException;
import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatException;
import menufact.plats.platMenuCreate;

import static org.junit.Assert.*;

public class TestFacture {
    @org.junit.Test
    /**
     * This test check if you can add a dish to the facture
     * (1) create the dish
     * (2) create the inventory
     * (3) create the chef
     * (4) create the facture
     * (5) Add the dish to the facture
     * (6) see if the number of dish on the facture is correct
     */
    public void Test1() throws IngredientException, ChefException, FactureException, PlatException {
        /**
         * (1)
         */
        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        /**
         * (2)
         */
        Inventaire inventaire =new Inventaire();
        /**
         * (3)
         */
        Chef chef = Chef.getInstance("Domingo", inventaire);
        /**
         * (4)
         */
        Facture fact1 = new Facture("Nouvelle Facture",chef);
        /**
         * (5)
         */
        PlatChoisi platChoisi = new PlatChoisi(monPlatAuMenu,5,Composition);
        try
        {
            fact1.ajoutePlat(platChoisi);
        }
        catch(IngredientException| ChefException| FactureException E)
        {
            System.out.println(E);
        }
        /**
         * (6)
         */
        assertEquals(1,fact1.getPlatChoisi().size());

    }
    @org.junit.Test
    /**
     * Test if you can remove the dish from the facture

     *      * (1) create the dish
     *      * (2) create the inventory
     *      * (3) create the chef
     *      * (4) create the facture
     *      * (5) Add the dish to the facture
     *      * (6) Remove the dish from the facture
     *      * (7) see if the number of dish on the facture is correct
     *      */

    public void Test2() throws FactureException, PlatException {
        /**
         * (1)
         */
        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        /**
         * (2)
         */
        Inventaire inventaire =new Inventaire();
        /**
         * (3)
         */
        Chef chef = Chef.getInstance("Domingo", inventaire);
        /**
         * (4)
         */
        Facture fact1 = new Facture("Nouvelle Facture",chef);
        /**
         * (5)
         */
        PlatChoisi platChoisi = new PlatChoisi(monPlatAuMenu,5,Composition);
        try
        {
            fact1.ajoutePlat(platChoisi);
        }
        catch(IngredientException| ChefException| FactureException E)
        {
            System.out.println(E);
        }
        /**
         * (6)
         */

        fact1.RemovePlatDelaFacture(platChoisi);
        /**
         * (7)
         */
        assertEquals(0,fact1.getPlatChoisi().size());

    }
    @ org.junit.Test
    /**
     * Test if you can associate a client to the facture

     *      * (1) create the dish
     *      * (2) create the inventory
     *      * (3) create the chef
     *      * (4) create the facture
     *      * (5) create a client
     *      * (6) associate the client to the facture
     *      * (7) verify if it's the same client
     *      */
    public void Test3() throws FactureException, PlatException {
        /**
         * (1)
         */
        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        /**
         * (2)
         */
        Inventaire inventaire =new Inventaire();
        /**
         * (3)
         */
        Chef chef = Chef.getInstance("Domingo", inventaire);
        /**
         * (4)
         */
        Facture fact1 = new Facture("Nouvelle Facture",chef);
        /**
         * (5)
         */
        Client client = new Client(1,"Stephanie","123456789");
        /**
         * (6)
         */
        fact1.associerClient(client);
        /**
         * (7)
         */
        assertEquals(fact1.getClient().hashCode(), client.hashCode());
    }
    @org.junit.Test
     /** Test if you can associate a client to the facture

     *      * (1) create the dish
     *      * (2) create the inventory
     *      * (3) create the chef
     *      * (4) create the facture
     *      * (5) change state
     *      * (6) verify if the change of state didn't cause an error
     *      */
    public void Test4() throws FactureException, PlatException {
        Boolean succeed =true;
        /**
         * (1)
         */
        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        /**
         * (2)
         */
        Inventaire inventaire =new Inventaire();
        /**
         * (3)
          */
        Chef chef = Chef.getInstance("Domingo", inventaire);
        /**
         * (4)
         */
        Facture fact1 = new Facture("Nouvelle Facture",chef);
        /**
         * (5)
         */
        fact1.payer();
        if(fact1.getEtat().getEtat() != FactureEtat.PAYEE )
        {
            succeed = false;
        }
        try
        {
           fact1.ouvrir();
        }
        catch(FactureException E)
        {
            System.out.println(E);
        }
        if(fact1.getEtat().getEtat() != FactureEtat.PAYEE )
        {
            succeed = false;
        }
        fact1.fermer();
        if(fact1.getEtat().getEtat() != FactureEtat.FERMEE )
        {
            succeed = false;
        }
        /**
         * (6)
         */
        assertEquals(true, succeed);
    }
}
