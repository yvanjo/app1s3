package ingredients;

public class Ingredient implements State{
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private String State;


    public String getState()
    {
        return State;
    }

    @Override
    public void doThis(String i){State=i;}

    public void setStateIngredient(String s){
        State=s;
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
