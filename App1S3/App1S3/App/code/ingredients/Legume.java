package ingredients;

public class Legume extends Ingredient{

    public Legume(String nom,String s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.LEGUME);
    }
}
