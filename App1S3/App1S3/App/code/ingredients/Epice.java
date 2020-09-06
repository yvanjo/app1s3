package ingredients;

public class Epice extends Ingredient {
    private static Epice instance;
    private Epice(String s) {
        setStateIngredient(s);
        setTypeIngredient(TypeIngredient.EPICE);
    }

    public static Epice getInstanceEpice(String s){
        if(instance==null)
            instance = new Epice(s);
        return instance;
    }
}