package Chef;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.PlatChoisi;


import java.util.ArrayList;

public class Chef {
    private static Chef instanceChef;
    private String nom;
    private ArrayList<PlatChoisi> commandeQueue = new ArrayList<PlatChoisi>();
    private PlatChoisi platChoisi;
    private Facture facture;
    private Inventaire inventaire;
    private Chef(String nom, Inventaire inventaire)
    {
        this.nom = nom;
        this.inventaire = inventaire;
    }

    public static Chef getInstance (String nom, Inventaire inventaire) {
        if (instanceChef == null) {
            instanceChef = new Chef(nom, inventaire);
        }
        return instanceChef;
    }

    public void Work(Facture facture, PlatChoisi platChoisi) throws IngredientException, ChefException {
        commandeQueue.add(platChoisi);
        this.facture = facture;
        for (int i = 0; i < commandeQueue.size(); i++
             ) {
            this.platChoisi = commandeQueue.get(i);
            setEtatPlatChoisi();
        }
    }

    public ArrayList<PlatChoisi> getCommandeQueue()
    {
        return commandeQueue;
    }

    public PlatChoisi getPlat()
    {
        return platChoisi;
    }

    public IngredientInventaire getIngredientInventaire(int i)
    {
        return inventaire.getElementInventaire(i);
    }

    public Inventaire getInventaire()
    {
        return inventaire;
    }

    public Facture getFacture()
    {
        return facture;
    }

    public void setEtatPlatChoisi() throws IngredientException, ChefException {
        Handler verification = new VerificationDesIngredients(this);
        Handler preparation = new Preparation(this);
        Handler finalisation = new Finalisation(this);

        ((VerificationDesIngredients) verification).setNext(preparation);
        ((Preparation) preparation).setNext(finalisation);
        verification.callNext();

    }

}
class Finalisation implements Handler
{
    private Chef chef;
    private Handler handler;
    public Finalisation(Chef chef)
    {
        this.chef = chef;
    }

    @Override
    public void setNext(Handler H)
    {
        handler = H;
    }

    @Override
    public void callNext()
    {
        Handle(this.chef);
    }

    @Override
    public void Handle(Chef chief)
    {
        chef.getCommandeQueue().remove(chef.getPlat());
    }
}
 interface Handler {

    public default void setNext(Handler H)
    {

    }

    public default void callNext() throws IngredientException, ChefException {

    }

    public default void Handle(Chef chief) throws IngredientException, ChefException {

    }

}
 class Impossible implements Handler
{
    private Chef chef;
    private Handler handler;
    public Impossible(Chef chef)
    {
        this.chef = chef;
    }

    @Override
    public void setNext(Handler H)
    {
        handler = H;
    }

    @Override
    public void callNext() throws ChefException {
        Handle(chef);
    }

    @Override
    public void Handle(Chef chef) throws ChefException {
        chef.getCommandeQueue().remove(chef.getPlat());
        chef.getFacture().RemovePlatDelaFacture(chef.getPlat());
            throw new ChefException("not enough ingredients");

    }
}
class Preparation implements Handler {

    private Chef chef;
    private Handler handler;
    public Preparation (Chef chef)
    {
        this.chef  = chef;
    }

    @Override
    public void setNext(Handler H)
    {
        handler = H;
    }

    @Override
    public void callNext() throws IngredientException, ChefException {
        Handle(this.chef);
        handler.callNext();
    }

    @Override
    public void Handle(Chef chief) throws IngredientException {
        for (int i = 0; i< chief.getInventaire().getCount(); i++
        )
        {
            for (int e = 0; e < chief.getPlat().getInventaire().getCount(); e++
            ) {

                if (chief.getIngredientInventaire(i).getIngredient() == chief.getPlat().getInventaire().getElementInventaire(e).getIngredient()) {
                    chief.getIngredientInventaire(i).setQuantite(chief.getIngredientInventaire(i).getQuantite() - chief.getPlat().getInventaire().getElementInventaire(e).getQuantite() * chief.getPlat().getPlat().getProportion());
                }
            }
        }
    }
}
 class VerificationDesIngredients implements Handler {
    private Chef chief;
    private Handler handler;

    public VerificationDesIngredients(Chef Chief)
    {
        this.chief = Chief;
    }

     @Override
    public void setNext(Handler H)
    {
        handler = H;
    }

     @Override
    public void callNext() throws IngredientException, ChefException {
        this.Handle(chief);

        handler.callNext();
    }

     @Override
    public void Handle(Chef Chief) {
        for (int i = 0; i< Chief.getInventaire().getCount(); i++
        )
        {
            for (int e = 0; e < Chief.getPlat().getInventaire().getCount(); e++
            ) {
                if (Chief.getIngredientInventaire(i).getIngredient() == Chief.getPlat().getInventaire().getElementInventaire(e).getIngredient()) {
                    if (Chief.getIngredientInventaire(i).getQuantite() < Chief.getPlat().getInventaire().getElementInventaire(e).getQuantite()) {
                        setNext(new Impossible(chief));
                    }

                }
            }
        }
    }
}

