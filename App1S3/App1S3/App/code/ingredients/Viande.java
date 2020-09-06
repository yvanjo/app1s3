package ingredients;

public class Viande extends Ingredient{

    private static Viande instance;

    private Viande(String s) {
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.VIANDE);
    }

    public static Viande getInstanceViande(String s){
        if(instance==null)
            instance = new Viande(s);
        return instance;
    }
}
