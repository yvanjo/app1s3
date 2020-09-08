package ingredients;

public class Ingredient{
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    private State state;
    private TypeUnite unite;


    public State getState()
    {
        return state;
    }

    public TypeUnite getUnite()
    {
        return unite;
    }

    public void setUnite()
    {
      unite = state.setUnit();
    }

    public void setStateIngredient(State s){
        if(state == null)
        {
            state=s;
        }

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
