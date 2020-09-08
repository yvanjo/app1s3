package ingredients;

public class Fruit extends Ingredient{

    public Fruit(String nom,State s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.FRUIT);
        setUnite();
    }

}
