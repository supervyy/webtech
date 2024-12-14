package WebTech.Webtech.controller;

import WebTech.Webtech.entity.Recipe;
import WebTech.Webtech.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {


    private RecipeService recipeService;


    @GetMapping("/recipes")
    public ResponseEntity<Iterable<Recipe>> findAllRecipes() {

    }

    @PostMapping
    public ResponseEntity<Recipe> addHero(@Valid @RequestBody final Recipe recipe) {
        final Recipe created = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
