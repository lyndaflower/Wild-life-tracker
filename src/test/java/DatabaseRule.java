import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before(){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:4567/wildlife_tracker_test", "v", "1234");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            con.createQuery(deleteSightingsQuery).executeUpdate();
            con.createQuery(deleteAnimalsQuery).executeUpdate();
        }
    }
}