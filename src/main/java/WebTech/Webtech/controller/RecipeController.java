package WebTech.Webtech.controller;

import WebTech.Webtech.entity.Recipe;
import WebTech.Webtech.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("recipes")
public class RecipeController {


    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Recipe>> getAllRecipes() {
        final Iterable<Recipe> result = recipeService.getAllRecipes();
        return ResponseEntity.ok(result);

    }
    @GetMapping(value = "/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Recipe>> getRecipesByCategory(@PathVariable("category") String category) {
        final Iterable<Recipe> result = recipeService.getRecipesByCategory(category);
        return ResponseEntity.ok(result);
    }
    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Recipe>> getRecipesByName(@PathVariable("name") String name) {
        final Iterable<Recipe> result = recipeService.getRecipesByName(name);
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable("id") final int id) {
        final Optional<Recipe> recipeOptional = recipeService.getRecipeById(id);
        if (!recipeOptional.isPresent()) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(recipeOptional.get());
    }

    @PostMapping("/create")
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody final Recipe recipe) {
        final Recipe created = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        Recipe updated = recipeService.editRecipe(recipe);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") int id) {
        return recipeService.removeRecipe(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
