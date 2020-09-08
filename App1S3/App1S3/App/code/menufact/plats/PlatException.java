package menufact.plats;

public class PlatException extends Exception {
    public PlatException(String message){
        super("FactureException: " + message);
    }
}
