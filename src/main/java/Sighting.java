import org.sql2o.*;
import java.util.List;


public class Sighting{
    private String name;
    private String location;
    private int id;
    private String animalId;


    public Sighting(String name, String location, String animalId) {
        this.name = name;
        this.location = location;
        this.animalId = animalId;
    }

    public String getLocation(){
        return location;
    }

    public String getAnimalId(){
        return animalId;
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings (name, location) VALUES (:name, :location)";
            this.id = (int) con.createQuery(sql, true)
                               .addParameter("name", this.name)
                               .addParameter("location", this.location)
                               .executeUpdate()
                               .getKey();
        }
    }

    public static List<Sighting> all(){
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                      .executeAndFetch(Sighting.class);
        }
    }

    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings where id = :id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }
}
