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
        when(service.getRecipeById(1)).thenReturn(Optional.of(Tiramisu));
    }

    @Test
    void testGetRecipeById() throws Exception {
        final String expectation = "{\"id\":1,\"name\":\"Tiramisu\",\"description\":\"Italian dessert\",\"image\":\"image1.jpg\",\"category\":\"Dessert\",\"ingredients\":\"mascarpone, coffee\",\"instructions\":\"Mix mascarpone with coffee\",\"author\":\"John\",\"favorite\":true}";
        this.mockMvc.perform(get("/api/recipes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(equalTo(expectation)));
    }
}
