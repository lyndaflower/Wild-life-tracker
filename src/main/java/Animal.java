import org.sql2o.Connection;
import java.util.List;

public class Animal {

    public String health;
    public String age;
    public String name;
    public int id;
    public static final String HEALTH_1 = "healthy";
    public static final String HEALTH_2 = "okay";
    public static final String HEALTH_3 = "ill";
    public static final String AGE_1 = "newborn";
    public static final String AGE_2 = "young";
    public static final String AGE_3 = "adult";


    public Animal(String name, String health, String age) {
        this.name = name;
        this.health =health;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }
    public String getHealth(){
        return health;
    }
    public String getAge(){
        return age;
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
    public List<Animal> getAnimal(){
        try(Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM animals as where id=:id";
           return con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeAndFetch(Animal.class);
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

