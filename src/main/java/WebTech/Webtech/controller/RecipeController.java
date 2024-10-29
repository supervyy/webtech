package WebTech.Webtech.controller;

import WebTech.Webtech.entity.Recipe;
import WebTech.Webtech.service.IRecipeService;
import WebTech.Webtech.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {


    private IRecipeService recipeService ;

    public RecipeController(IRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe")
    public List<Recipe> findAllRecipes() {
        return recipeService.findAllRecipes();
    }
}
