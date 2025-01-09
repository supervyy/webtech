package WebTech.Webtech.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RecipeTest {

    @Test
    void testRecipeToString() {

        final Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setName("Spaghetti Carbonara");
        recipe.setDescription("A classic Italian pasta dish");
        recipe.setImage("https://i.pinimg.com/736x/fe/07/27/fe072747470c09eeadfcac3f450a130e.jpg");
        recipe.setCategory("Main Course");
        recipe.setIngredients("Spaghetti, Eggs, Parmesan");
        recipe.setInstructions("1. Cook spaghetti in salted water until al dente");
        recipe.setAuthor("John Doe");
        recipe.setFavorite(true);

        final String expected = "Recipe(id=1, " +
                "name=Spaghetti Carbonara, " +
                "description=A classic Italian pasta dish, " +
                "image=https://i.pinimg.com/736x/fe/07/27/fe072747470c09eeadfcac3f450a130e.jpg, " +
                "category=Main Course, " +
                "ingredients=Spaghetti, Eggs, Parmesan, " +
                "instructions=1. Cook spaghetti in salted water until al dente, " +
                "author=John Doe, " +
                "favorite=true)";
                
        final String result = recipe.toString();

        assertEquals(expected, result);
    }
}
