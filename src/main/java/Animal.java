import org.sql2o.Connection;
import java.util.List;

public class Animal {

    private String health;
    private String age;
    private String name;
    private int id;

    public Animal(String name, String health, String age) {
        this.name = name;
        this.health =health;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getHealth(){
        return health;
    }
    public String getAge(){
        return age;
    }
    public int getId(){
        return id;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, health, age) VALUES (:name, :health,:age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("health",this.health)
                    .addParameter("age",this.age)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static Animal find(int id){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                         .addParameter("id", id)
                         .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }

    public static List<Animal> all(){
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }
    }

}

