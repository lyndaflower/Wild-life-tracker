
import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;


public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true(){
        Sighting testSighting = new Sighting("lynda", "nyungwe", 1);
        assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void getName_personInstantiatesWithRangerName_John(){
        Sighting testSighting = new Sighting("lynda", "nyungwe", 1);
        assertEquals("lynda", testSighting.getName());
    }

    @Test
    public void getAnimalId_instantiatesWithAnimalId_int(){
        Sighting testSighting = new Sighting("lynda", "nyungwe", 1);
        assertEquals(1, testSighting.getAnimalId());
    }

    @Test
    public void getLocation_sightingInstatiatesWithLocation_String(){
        Sighting testSighting = new Sighting("lynda", "nyungwe", 1);
        assertEquals("nyungwe", testSighting.getLocation());
    }

    @Test
    public void save_insertsObjectIntoDatabase_Sighting(){
        Sighting testSighting = new Sighting("John", "North Forest", 1);
        testSighting.save();
        assertTrue(Sighting.all().get(0).equals(testSighting));
    }

    @Test
    public void all_returnsAllInstancesOfASighting(){
        Sighting firstSighting = new Sighting("John", "nyungwe", 1);
        firstSighting.save();
        Sighting secondSighting = new Sighting("Beth", "SE Forest", 2);
        secondSighting.save();
        assertEquals(true, Sighting.all().get(0).equals(firstSighting));
        assertEquals(true, Sighting.all().get(1).equals(secondSighting));
    }

    @Test
    public void save_assignesIdToSavedObjects(){
        Sighting testSighting = new Sighting("John", "North Forest", 1);
        testSighting.save();
        Sighting anotherSighting = Sighting.all().get(0);
        assertEquals(testSighting.getId(), anotherSighting.getId());
    }

    @Test
    public void find_findObjectWithId(){
        Sighting testSighting = new Sighting("John", "North Forest", 1);
        testSighting.save();
        Sighting secondSighting = new Sighting("Jane", "SE Forest", 2);
        secondSighting.save();
        assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
    }

}
