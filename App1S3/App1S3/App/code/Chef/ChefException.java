package Chef;

public class ChefException extends Exception {
    public ChefException(String message) {
        super("IngredientException: " + message);
    }
}
