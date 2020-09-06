package ingredients;

public class Laitier extends Ingredient {
    private static Laitier instance;
    private Laitier(String s) {
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.LAITIER);
    }

    public static Laitier getInstanceLaitier(String s){
        if(instance==null)
            instance = new Laitier(s);
        return instance;
    }
}