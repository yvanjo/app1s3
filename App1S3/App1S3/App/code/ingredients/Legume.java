package ingredients;

public class Legume extends Ingredient{
    private static Legume instance;
    private Legume(String s) {
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.LEGUME);
    }

    public static Legume getInstanceLegume(String s){
        if(instance==null)
            instance = new Legume(s);
        return instance;
    }
}
