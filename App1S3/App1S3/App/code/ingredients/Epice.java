package ingredients;

public class Epice extends Ingredient {

    public Epice(String nom,State s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.EPICE);
        setUnite();
    }

}