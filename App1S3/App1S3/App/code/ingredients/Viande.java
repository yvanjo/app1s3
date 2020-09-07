package ingredients;

public class Viande extends Ingredient{

    public Viande(String nom,State s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.VIANDE);
    }

}
