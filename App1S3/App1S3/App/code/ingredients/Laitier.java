package ingredients;

public class Laitier extends Ingredient {
    public Laitier(String nom, String s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.LAITIER);
    }

}