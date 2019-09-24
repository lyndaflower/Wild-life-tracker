import org.sql2o.Connection;
import java.util.List;
import java.util.ArrayList;

public class Animal {

    private String name;;
    private int id;
    private static ArrayList<Animal> instances = new ArrayList<>();

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();
        }
    }


    public static Animal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(Animal.class);
            return animal;
        }
    }


    public List<Animal> getAnimal(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals as where id=:id";
           return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Animal.class);
        }
    }



    public static List<Animal> all(){
        String sql = "SELECT * FROM animals;";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql).throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }
    }




}

