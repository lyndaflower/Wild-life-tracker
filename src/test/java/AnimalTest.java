import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void  animal_instantiatesCorrectly_true(){
        Animal testAnimal = new Animal("Giraffe");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void Animal_instantiatesWithName(){
        Animal testAnimal = new Animal("Giraffe");
        assertEquals("Giraffe",testAnimal.getName());
    }


}