package ingredients;

public class Legume extends Ingredient{

    public Legume(String nom,State s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.LEGUME);
    }
}
