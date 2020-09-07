package ingredients;

public class Fruit extends Ingredient{

    public Fruit(String nom,String s) {
        setNom(nom);
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.FRUIT);
    }

}
