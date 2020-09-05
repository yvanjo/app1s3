package Chef;

import ingredients.*;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import org.junit.ClassRule;

import static org.junit.Assert.*;

public class TestChef {

    @org.junit.Test
     /*
        Here we are checking if chef is a singleton
     */
    public void test1() throws IngredientException {

        Inventaire gardeManger = new Inventaire();

        Boolean succeed = true;
        Chef chef =Chef.getInstance("Stephanie",gardeManger);
        Chef chef1 = Chef.getInstance("Philippe", gardeManger);
        if (chef.hashCode() == chef.hashCode()){
            succeed = true;
        }
        else{
            succeed =false;
        }
        assertEquals(true,succeed);
    }

}
