package ingredients;

public class Fruit extends Ingredient{
    private static Fruit instance;
    private Fruit(String s) {
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.FRUIT);
    }
    public static Fruit getInstanceFruit(String s){
        if(instance==null)
            instance = new Fruit(s);
        return instance;
    }
}
