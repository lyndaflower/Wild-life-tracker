
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;


public class App {
    public static <Animals> void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/newanimal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sighting", (request, response) -> {
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
            String inputtedName = request.queryParams("name");
            Animal newAnimal = new Animal (inputtedName);

            newAnimal.save();
            model.put("name",inputtedName);
            return new ModelAndView(model, "animals.hbs");
        }, new HandlebarsTemplateEngine());

    }
}