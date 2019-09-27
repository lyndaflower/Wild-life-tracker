/*

import org.junit.*;
import static org.junit.Assert.*;


public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true(){
        Sighting testSighting = new Sighting("lynda", "nyungwe");
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void sighting_personInstantiatesWithName(){
        Sighting testSighting = new Sighting("lynda", "nyungwe");
        assertEquals("lynda", testSighting.getName());
    }

    @Test
    public void sighting_instantiatesWithLocation(){
        Sighting testSighting = new Sighting("lynda", "nyungwe");
        assertEquals("nyungwe", testSighting.getLocation());
    }

    @Test
    public void sighting_returnsAllInstancesOfASighting(){
        Sighting firstSighting = new Sighting("lynda", "nyungwe");
        firstSighting.save();
        Sighting secondSighting = new Sighting("Beth", "central");
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

    @Test
    public void save_assignesIdToSavedObjects(){
        Sighting testSighting = new Sighting("lynda", "nyungwe");
        testSighting.save();
        Sighting anotherSighting = Sighting.all().get(0);
        assertEquals(testSighting.getId(), anotherSighting.getId());
    }

    @Test
    public void find_findObjectWithId(){
        Sighting testSighting = new Sighting("lynda", "nyungwe");
        testSighting.save();
        Sighting secondSighting = new Sighting("beth", "central");
        secondSighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }

}
*/
