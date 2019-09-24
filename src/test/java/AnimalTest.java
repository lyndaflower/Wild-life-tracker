import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;
public class AnimalTest {

    @Rule
    DatabaseRule database = new DatabaseRule();

    @Test
    public void object_instantiatesAsAnAnimal_true(){
        Animal testAnimal = new Animal("Giraffe");
        assertTrue(testAnimal instanceof Animal);
    }

    @Test
    public void animal_instantiatesWithName_String(){
        Animal testAnimal = new Animal("Giraffe");
        assertEquals(testAnimal.getName(), "Giraffe");
    }

    @Test
    public void equals_returnsTrueIfNamesAreTheSame(){
        Animal testAnimal = new Animal("Giraffe");
        Animal secondAnimal = new Animal("Giraffe");
        assertTrue(testAnimal.equals(secondAnimal));
    }

    @Test
    public void save_returnsTrueIfDescriptionIsSame(){
        Animal testAnimal = new Animal("Giraffe");
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
    }

    @Test
    public void save_InstantiatesObjectWithId_int(){
        Animal testAnimal = new Animal("Giraffe");
        testAnimal.save();
        Animal anotherAnimal = Animal.all().get(0);
        assertEquals(testAnimal.getId(), anotherAnimal.getId());
    }
    @Test
    public void all_returnsAllInstancesOfAnimal_list(){
        Animal firstAnimal = new Animal("Giraffe");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Gorilla");
        secondAnimal.save();
        assertEquals(true, Animal.all().get(0).equals(firstAnimal));
        assertEquals(true, Animal.all().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalObjectBasedOnId_object(){
        Animal firstAnimal = new Animal("Giraffe");
        firstAnimal.save();
        Animal secondAnimal = new Animal("Boar");
        secondAnimal.save();
        assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
    }

}

