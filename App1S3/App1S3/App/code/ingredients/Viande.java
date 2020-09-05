package ingredients;

public class Viande extends Ingredient{
    public Viande(String s) {
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.VIANDE);
    }
}
