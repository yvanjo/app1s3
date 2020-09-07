package ingredients;

public class Viande extends Ingredient{

    public Viande(String nom,String s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.VIANDE);
    }

}
