package WebTech.Webtech.service;


import WebTech.Webtech.entity.Recipe;
import WebTech.Webtech.repository.IRecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

@SpringBootTest
public class RecipeServiceTest {

    @Autowired
    private RecipeService service;

    @MockBean
    private IRecipeRepository repository;

    @BeforeEach
    void setUpMockRepository() {
        final Recipe pasta = new Recipe(1, "Spaghetti", "Italian pasta", "image1.jpg", "Main Course", "pasta, sauce", "Cook pasta", "John", true);
        final Recipe chicken = new Recipe(2, "Chicken", "Asian dish", "image2.jpg", "Main Course", "chicken, sauce", "Fry chicken", "Jane", false);
        doReturn(List.of(pasta, chicken)).when(repository).findRecipeByCategory("Main Course");
        doReturn(List.of(pasta, chicken)).when(repository).findAll();
        doReturn(List.of(pasta)).when(repository).findRecipeByFavorite(true);
    }

    @Test
    void testGetRecipesByCategory() {
        List<Recipe> recipes = (List<Recipe>) service.getRecipesByCategory("Main Course");
        assertEquals(2, recipes.size(), "Number of recipes should be two for category=Main Course");
        assertEquals("Spaghetti", recipes.get(0).getName());
    }
    @Test
    void testGetAllRecipes() {
        List<Recipe> recipes = (List<Recipe>) service.getAllRecipes();
        assertEquals(2, recipes.size(), "Number of all recipes should be two");
        assertEquals("Spaghetti", recipes.get(0).getName());
        assertEquals("Chicken", recipes.get(1).getName());
    }

    @Test
    void testGetLikedRecipes() {
        List<Recipe> recipes = (List<Recipe>) service.getLikedRecipes();
        assertEquals(1, recipes.size(), "Number of liked recipes should be one");
        assertEquals("Spaghetti", recipes.get(0).getName());
        assertEquals(true, recipes.get(0).isFavorite());
    }
}