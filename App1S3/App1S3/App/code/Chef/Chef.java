package Chef;

import ingredients.IngredientInventaire;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.facture.Facture;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatEnfant;

import java.util.ArrayList;

public class Chef {
    private static Chef instanceChef;
    private String nom;
    private ArrayList<PlatChoisi> commandeQueue = new ArrayList<PlatChoisi>();
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

    public void Work(Facture facture, PlatChoisi platChoisi) throws IngredientException {
        commandeQueue.add(platChoisi);
        this.facture = facture;
        for (int i = 0; i < commandeQueue.size(); i++
             ) {
            setEtatPlatChoisi(commandeQueue.get(i));
        }
    }

    public void setEtatPlatChoisi(PlatChoisi pyt) throws IngredientException {
        for (int i = 0; i < inventaire.getCount(); i++
        ) {
            if(pyt.getEtat() == "Commander") {
                VerificationDesIngredients(pyt, inventaire.getElementInventaire(i));
            }
        }
        pyt.setState("En Preparation");
        if(pyt.getEtat() == "En Preparation") {
            for (int i = 0; i < inventaire.getCount(); i++
            ) {

                Preparation(pyt, inventaire.getElementInventaire(i));

            }
            pyt.setState("Terminer");
        }
        if(pyt.getEtat() =="Terminer")
        {
            commandeQueue.remove(pyt);
            pyt.setState("Servie");
        }
        if(pyt.getEtat() == "Impossible")
        {
            commandeQueue.remove(pyt);
            facture.RemovePlatDelaFacture(pyt);
        }
    }

    public void VerificationDesIngredients(PlatChoisi platChoisi,IngredientInventaire II)
    {
        for (int i = 0; i< platChoisi.getInventaire().getCount(); i++
             ) {
                if( II.getIngredient() == platChoisi.getInventaire().getElementInventaire(i).getIngredient())
                {
                    if(II.getQuantite() < platChoisi.getInventaire().getElementInventaire(i).getQuantite())
                    {
                        platChoisi.setState("Impossible");
                    }
                    break;
                }
            }
    }

    public void Preparation(PlatChoisi pyt, IngredientInventaire II) throws IngredientException {
        for (int i =0; i<pyt.getInventaire().getCount(); i++
             ) {

            if(II.getIngredient() == pyt.getInventaire().getElementInventaire(i).getIngredient())
            {
                II.setQuantite(II.getQuantite() - pyt.getInventaire().getElementInventaire(i).getQuantite() * pyt.getPlat().getProportion());
            }
        }
    }
}

