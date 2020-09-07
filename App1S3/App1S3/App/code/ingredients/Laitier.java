package ingredients;

public class Laitier extends Ingredient {
    public Laitier(String nom, State s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.LAITIER);
    }

}