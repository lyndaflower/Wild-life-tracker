import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void  animal_instantiatesCorrectly_true(){
        Animal testAnimal = new Animal("Giraffe",1);
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void Animal_instantiatesWithName(){
        Animal testAnimal = new Animal("Giraffe",1);
        assertEquals("Giraffe",testAnimal.getName());
    }
    @Test
    public void Animal_instantiatesWithPersonId(){
        Animal testAnimal = new Animal("Girrafe",1);
        assertEquals(1,testAnimal.getId());

    }

}