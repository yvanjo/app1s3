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
import menufact.plats.platMenuCreate;

import static org.junit.Assert.*;

public class TestFacture {
    @org.junit.Test
    /*
    Test ajouter plat
     */
    public void Test1() throws IngredientException, ChefException, FactureException {

        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        Inventaire inventaire =new Inventaire();
        Chef chef = Chef.getInstance("Domingo", inventaire);
        Facture fact1 = new Facture("Nouvelle Facture",chef);
        PlatChoisi platChoisi = new PlatChoisi(monPlatAuMenu,5,Composition);
        try
        {
            fact1.ajoutePlat(platChoisi);
        }
        catch(IngredientException| ChefException| FactureException E)
        {
            System.out.println(E);
        }
        assertEquals(1,fact1.getPlatChoisi().size());

    }
    @org.junit.Test
    /*
    Test retirer un plat
     */
    public void Test2() throws FactureException {
        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        Inventaire inventaire =new Inventaire();
        Chef chef = Chef.getInstance("Domingo", inventaire);
        Facture fact1 = new Facture("Nouvelle Facture",chef);
        PlatChoisi platChoisi = new PlatChoisi(monPlatAuMenu,5,Composition);
        try
        {
            fact1.ajoutePlat(platChoisi);
        }
        catch(IngredientException| ChefException| FactureException E)
        {
            System.out.println(E);
        }

        fact1.RemovePlatDelaFacture(platChoisi);
        assertEquals(0,fact1.getPlatChoisi().size());

    }
    @ org.junit.Test
    /*
    Test associer client
     */
    public void Test3() throws FactureException {
        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        Inventaire inventaire =new Inventaire();
        Chef chef = Chef.getInstance("Domingo", inventaire);
        Facture fact1 = new Facture("Nouvelle Facture",chef);
        Client client = new Client(1,"Stephanie","123456789");
        fact1.associerClient(client);
        assertEquals(fact1.getClient().hashCode(), client.hashCode());
    }
    @org.junit.Test
    /*
    Changer d'etat
     */
    public void Test4() throws FactureException {
        Boolean succeed =true;
        Inventaire Composition =new Inventaire();
        platMenuCreate platMenu = new platMenuCreate();
        PlatAuMenu monPlatAuMenu = platMenu.createPlats(1,"un bon risoto",20.00,Composition);
        Inventaire inventaire =new Inventaire();
        Chef chef = Chef.getInstance("Domingo", inventaire);
        Facture fact1 = new Facture("Nouvelle Facture",chef);
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
        assertEquals(true, succeed);
    }
}
