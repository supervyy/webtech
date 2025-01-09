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
    }

    @Test
    void testGetRecipesByCategory() {
        List<Recipe> recipes = (List<Recipe>) service.getRecipesByCategory("Main Course");
        assertEquals(2, recipes.size(), "Number of recipes should be two for category=Main Course");
        assertEquals("Spaghetti", recipes.get(0).getName());
    }
}