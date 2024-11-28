package WebTech.Webtech.repository;

import WebTech.Webtech.entity.Recipe;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {

    private final List<Recipe> recipes = new ArrayList<>();

    public List<Recipe> findAll(){
        return recipes;

    }
    //public Recipe findById(int id){

    //}
    @PostConstruct
    private void init(){
    recipes.add(new Recipe(
                1, // recipeId
                "Tiramisu",
            "Dessert",
            "250g Mascarpone, 200ml Sahne, 100g Zucker, 1 Tasse starker Kaffee, 2 EL Kakaopulver, 200g Löffelbiskuits, 3 Eier",// recipeName
                "1. Den Kaffee zubereiten und abkühlen lassen.\n" +
                        "2. Die Eier trennen und das Eigelb mit dem Zucker schaumig schlagen.\n" +
                        "3. Mascarpone unter die Eigelb-Zucker-Mischung heben.\n" +
                        "4. Das Eiweiß steif schlagen und vorsichtig unter die Mascarpone-Mischung heben.\n" +
                        "5. Die Löffelbiskuits kurz im Kaffee tränken und in eine Auflaufform schichten.\n" +
                        "6. Eine Schicht der Mascarpone-Creme darüber geben.\n" +
                        "7. Diesen Vorgang wiederholen und mit der Creme abschließen.\n" +
                        "8. Mindestens 4 Stunden im Kühlschrank kaltstellen und vor dem Servieren mit Kakaopulver bestäuben.",
                       "Chef Boyo"
                ));
    recipes.add(new Recipe(
            2,
            "Korean Fried Chicken",
            "Fingerfood",
            "• 1 kg Hähnchenflügel\n" +
            "• 2 EL Sojasauce\n" +
            "• 2 Knoblauchzehen (gehackt)\n" +
            "• 1 Stück Ingwer (gerieben)\n" +
            "• 100 g Maisstärke\n" +
            "• 100 g Mehl\n" +
            "• Öl zum Frittieren\n" +
            "• Sesam und Frühlingszwiebeln zum Garnieren",
            "1. Hähnchenstücke in einer Mischung aus Sojasauce, Knoblauch und Ingwer marinieren.\n" +
                    "2. Hähnchen in einer Mischung aus Maisstärke und Mehl wenden.\n" +
                    "3. Öl in einem Wok erhitzen und die Hähnchenstücke frittieren, bis sie goldbraun und knusprig sind.\n" +
                    "4. Mit einer süß-sauren Soße überziehen und mit Sesam und Frühlingszwiebeln garnieren.", "Noobanh"));
    }





}
