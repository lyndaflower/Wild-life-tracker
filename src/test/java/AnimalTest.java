/*
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
public class AnimalTest {

    @Rule
    DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesWithName(){
        Animal testAnimal = new Animal("Giraffe","ill","2");
        assertEquals(testAnimal.getName(), "Giraffe");
    }

    @Test
    public void animal_instantiatesWithHealth(){
        Animal testAnimal = new Animal("Giraffe","ill","2");
        assertEquals(testAnimal.getHealth(), "healthy");
    }

    @Test
    public void animal_instantiatesWithAge(){
        Animal testAnimal = new Animal("Giraffe","ill","2");
        assertEquals(testAnimal.getAge(), "young");
    }

    @Test
    public void animal_instantiatesWithId(){
        Animal testAnimal = new Animal("Giraffe","ill","2");
        assertEquals(testAnimal.getId(), "2");
    }

    @Test
    public void all_returnsAllInstancesOfAnimal() {
        Animal firstAnimal = new Animal("Giraffe", "ill", "2");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Giraffe", "ill", "2");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }
}
*/
