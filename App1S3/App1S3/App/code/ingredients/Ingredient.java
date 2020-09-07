package ingredients;

public class Ingredient implements State{
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private State state;


    public State getState()
    {
        return state;
    }



    public void setStateIngredient(State s){
        state=s;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }



}
