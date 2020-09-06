package menufact.facture;

import Chef.Chef;
import Chef.ChefException;
import ingredients.exceptions.IngredientException;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Domingo Palao Munoz
 * @version 1.0
 */
public class Facture {
    private Date date;
    private String description;
    private StateFacture etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;
    private Chef chief;

    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;



    public double getTps()
    {
        return TPS;
    }

    public double getTvq()
    {
        return TVQ;
    }
   public Date getDate()
   {
       return date;
   }

   public String getDescription()
   {
       return description;
   }

    public ArrayList<PlatChoisi> getPlatChoisi()
    {
        return platchoisi;
    }

    public int getCourant()
    {
        return courant;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Chef getChief()
    {
        return chief;
    }

    public void associerClient (Client client) throws FactureException {
        etat.associerClient(client);
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal() throws FactureException {
        return etat.sousTotal();
    }

    public void RemovePlatDelaFacture(PlatChoisi platChoisi)
    {
        platchoisi.remove(platChoisi);
    }

    /**
     *
     * @return le total de la facture
     */
    public double total() throws FactureException {
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps() throws FactureException {
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq() throws FactureException {
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de chager l'état de la facture à PAYEE
     */
    public void payer()
    {
       etat = new FacturePayee(this);
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer()
    {
       etat = new FactureFermee(this);
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        if (etat.getEtat() == FactureEtat.PAYEE)
            throw new FactureException("La facture ne peut pas être reouverte.");
        else
            etat = new FactureOuverte(this);
    }

    /**
     *
     * @return l'état de la facture
     */
    public StateFacture getEtat()
    {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description, Chef chef) {
        date = new Date();
        courant = -1;
        chief = chef;
        this.description = description;
        etat = new FactureOuverte(this);
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, IngredientException, ChefException {

        if (etat .getEtat()== FactureEtat.OUVERTE) {
            platchoisi.add(p);
            chief.Work(this,p);
        }
        else
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");

    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture() throws FactureException {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                          "Date:" + date + "\n" +
                          "Description: " + description + "\n" +
                          "Client:" + client.getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
}
interface StateFacture
{
    public default void  ajoutePlat(PlatChoisi p) throws FactureException, IngredientException, ChefException,FactureException {
        throw new FactureException("Aucun plat ne peut être ajouter sous cette etat");
    }

    public default void associerClient (Client client)throws FactureException {
        throw new FactureException("Aucun client ne peut être associer sous cette etat");
    }

    public default void RemovePlatDelaFacture(PlatChoisi platChoisi) throws FactureException {
        throw new FactureException("on ne peut retirer de plats dans cette etat");
    }

    public FactureEtat getEtat();
    public String toString();

    public default double sousTotal() throws FactureException {
        throw new FactureException("Aucun sous total ne peut-être implémenter pour cette état");
    }

    public default double total() throws FactureException {
        throw new FactureException("ne peut calculer le total ");
    }

    public default double tps()throws FactureException {
        throw new FactureException("ne peut calculer la tps");
    }

    public default double tvq()throws FactureException {
        throw new FactureException("ne peut pas calculer la tvq sous cette état");
    }

    public default String genererFacture()throws FactureException {
        throw new FactureException("ne peut pas generer facture sous cette état");
    }
}

class FactureOuverte implements StateFacture
{
    private Facture facture;
    private FactureEtat factureEtat = FactureEtat.OUVERTE;
    public FactureOuverte(Facture facture)
    {
        this.facture = facture;
    }
    @Override
    public String toString()
    {
        return "menufact.facture.Facture{" +
                "date=" + this.facture.getDate() +
                ", description='" + this.facture.getDescription() + '\'' +
                ", etat=" + "Ouverte" +
                ", platchoisi=" + this.facture.getPlatChoisi() +
                ", courant=" + this.facture.getCourant() +
                ", client=" + this.facture.getClient() +
                ", TPS=" + this.facture.getTps() +
                ", TVQ=" + this.facture.getTvq() +
                '}';
    }
    @Override
    public FactureEtat getEtat()
    {
        return factureEtat;
    }

    public void ajoutePlat(PlatChoisi p) throws FactureException, IngredientException, ChefException {
        this.facture.getPlatChoisi().add(p);
        this.facture.getChief().Work(this.facture,p);
    }
    public void associerClient (Client client)
    {
        this.facture.setClient(client);
    }

    public  void RemovePlatDelaFacture(PlatChoisi platChoisi)
    {
        this.facture.getPlatChoisi().remove(platChoisi);
    }
}

class FacturePayee implements StateFacture
{
    private Facture facture;
    private FactureEtat factureEtat = FactureEtat.PAYEE;
    public FacturePayee(Facture facture)
    {
        this.facture = facture;
    }

    @Override
    public FactureEtat getEtat()
    {
        return factureEtat;
    }

    @Override
    public String toString()
    {
        return "menufact.facture.Facture{" +
                "date=" + this.facture.getDate() +
                ", description='" + this.facture.getDescription() + '\'' +
                ", etat=" + "Ouverte" +
                ", platchoisi=" + this.facture.getPlatChoisi() +
                ", courant=" + this.facture.getCourant() +
                ", client=" + this.facture.getClient() +
                ", TPS=" + this.facture.getTps() +
                ", TVQ=" + this.facture.getTvq() +
                '}';
    }

    public double sousTotal()
    {
        double soustotal=0;
        for (PlatChoisi p : this.facture.getPlatChoisi())
            soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }
    public double total(){
        return sousTotal()+tps()+tvq();
    }


    public double tps(){
        return this.facture.getTps()*sousTotal();
    }


    public double tvq(){
        return this.facture.getTvq()*(this.facture.getTps()+1)*sousTotal();
    }
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                "Date:" + this.facture.getDate() + "\n" +
                "Description: " + this.facture.getDescription() + "\n" +
                "Client:" + this.facture.getClient().getNom() + "\n" +
                "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : this.facture.getPlatChoisi())
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
}

class FactureFermee implements StateFacture
{
    private Facture facture;
    private FactureEtat factureEtat = FactureEtat.FERMEE;
    public FactureFermee(Facture facture)
    {
        this.facture = facture;
    }

    @Override
    public FactureEtat getEtat()
    {
        return factureEtat;
    }

    @Override
    public String toString()
    {
        return "menufact.facture.Facture{" +
                "date=" + this.facture.getDate() +
                ", description='" + this.facture.getDescription() + '\'' +
                ", etat=" + "Ouverte" +
                ", platchoisi=" + this.facture.getPlatChoisi() +
                ", courant=" + this.facture.getCourant() +
                ", client=" + this.facture.getClient() +
                ", TPS=" + this.facture.getTps() +
                ", TVQ=" + this.facture.getTvq() +
                '}';
    }
}

