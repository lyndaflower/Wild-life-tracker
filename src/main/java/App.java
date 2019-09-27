
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static <Animals> void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newanimal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addsighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Animal> animal = Animal.all();
            model.put("animal", animal);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());


        post("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String  health= request.queryParams("health");
            String age = request.queryParams("age");
            Animal newAnimal = new Animal (name,health, age);

            newAnimal.save();
            model.put("name",name);
            model.put("health",health);
            model.put("age",age);

            response.redirect("/animals");
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/result", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Sighting> sightting= Sighting.all();
            model.put("sightting", sightting);
            return new ModelAndView(model, "result.hbs");
        }, new HandlebarsTemplateEngine());

        post("/sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String location = request.queryParams("location");
            Sighting newSighting = new Sighting(name, location);

            newSighting.save();
            model.put("name",name);
            model.put("location", location);
            response.redirect("/result");
            return new ModelAndView(model, "sighting.hbs");
        }, new HandlebarsTemplateEngine());
        }
}