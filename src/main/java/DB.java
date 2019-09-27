import org.sql2o.*;

public class DB {
   /* public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife", "wecode", "123456");*/
   static String connectionString = "jdbc:postgresql://ec2-50-19-95-77.compute-1.amazonaws.com:5432/dco77vtfrn78ln"; //!
    static Sql2o sql2o = new Sql2o(connectionString, "ogrwmlpuzvhkhq", "70a0f7aba483ac2738bd89404290ea1e7945bc8618ca7dfc0b3905143f3317bc"); //!

}