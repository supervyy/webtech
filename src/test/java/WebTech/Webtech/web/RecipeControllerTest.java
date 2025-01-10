package WebTech.Webtech.web;


import WebTech.Webtech.entity.Recipe;
import WebTech.Webtech.service.RecipeService;
import WebTech.Webtech.controller.RecipeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService service;

    @BeforeEach
    void setUpMockRepository() {
        final Recipe Tiramisu = new Recipe(1, "Tiramisu", "Italian dessert", "image1.jpg", "Dessert", "mascarpone, coffee", "Mix mascarpone with coffee", "John", true);
        final Recipe Spaghetti = new Recipe(2, "Spaghetti", "Italian pasta", "image2.jpg", "Main Course", "pasta, sauce", "Cook pasta", "Jane", false);
        when(service.getRecipeById(1)).thenReturn(Optional.of(Tiramisu));
        when(service.getAllRecipes()).thenReturn(List.of(Tiramisu, Spaghetti));
        when(service.getRecipesByCategory("Dessert")).thenReturn(List.of(Tiramisu));
        when(service.getRecipesByName("Tiramisu")).thenReturn(List.of(Tiramisu));
        when(service.getLikedRecipes()).thenReturn(List.of(Tiramisu));
    }

    @Test
    void testGetRecipeById() throws Exception {
        final String expectation = "{\"id\":1,\"name\":\"Tiramisu\",\"description\":\"Italian dessert\",\"image\":\"image1.jpg\",\"category\":\"Dessert\",\"ingredients\":\"mascarpone, coffee\",\"instructions\":\"Mix mascarpone with coffee\",\"author\":\"John\",\"favorite\":true}";
        this.mockMvc.perform(get("/recipes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }
    @Test
    void testGetAllRecipes() throws Exception {
        final String expectation = "[{\"id\":1,\"name\":\"Tiramisu\",\"description\":\"Italian dessert\",\"image\":\"image1.jpg\",\"category\":\"Dessert\",\"ingredients\":\"mascarpone, coffee\",\"instructions\":\"Mix mascarpone with coffee\",\"author\":\"John\",\"favorite\":true},{\"id\":2,\"name\":\"Spaghetti\",\"description\":\"Italian pasta\",\"image\":\"image2.jpg\",\"category\":\"Main Course\",\"ingredients\":\"pasta, sauce\",\"instructions\":\"Cook pasta\",\"author\":\"Jane\",\"favorite\":false}]";
        this.mockMvc.perform(get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }
    @Test
    void testGetRecipesByCategory() throws Exception {
        final String expectation = "[{\"id\":1,\"name\":\"Tiramisu\",\"description\":\"Italian dessert\",\"image\":\"image1.jpg\",\"category\":\"Dessert\",\"ingredients\":\"mascarpone, coffee\",\"instructions\":\"Mix mascarpone with coffee\",\"author\":\"John\",\"favorite\":true}]";
        this.mockMvc.perform(get("/recipes/category/Dessert"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }
    @Test
    void testGetRecipesByName() throws Exception {
        final String expectation = "[{\"id\":1,\"name\":\"Tiramisu\",\"description\":\"Italian dessert\",\"image\":\"image1.jpg\",\"category\":\"Dessert\",\"ingredients\":\"mascarpone, coffee\",\"instructions\":\"Mix mascarpone with coffee\",\"author\":\"John\",\"favorite\":true}]";
        this.mockMvc.perform(get("/recipes/name/Tiramisu"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }

    @Test
    void testGetLikedRecipes() throws Exception {
        final String expectation = "[{\"id\":1,\"name\":\"Tiramisu\",\"description\":\"Italian dessert\",\"image\":\"image1.jpg\",\"category\":\"Dessert\",\"ingredients\":\"mascarpone, coffee\",\"instructions\":\"Mix mascarpone with coffee\",\"author\":\"John\",\"favorite\":true}]";
        this.mockMvc.perform(get("/recipes/liked"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }
    


}
