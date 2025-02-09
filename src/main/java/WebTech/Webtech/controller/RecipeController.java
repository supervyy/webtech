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
    @GetMapping(value = "/liked", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Recipe>> getLikedRecipes() {
        final Iterable<Recipe> result = recipeService.getLikedRecipes();
        return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
    }


    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@Valid @RequestBody final Recipe recipe) {
        final Recipe created = recipeService.addRecipe(recipe);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PatchMapping("/favorite/{id}")
    public ResponseEntity<Recipe> updateFavorites(@PathVariable("id") int id, @RequestParam(required = false) Boolean favorite) {

        if (favorite == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Optional<Recipe> optionalRecipe = recipeService.getRecipeById(id);
        if (!optionalRecipe.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Recipe recipe = optionalRecipe.get();
        recipe.setFavorite(favorite);

        Recipe updatedRecipe = recipeService.editRecipe(recipe);

        return ResponseEntity.ok(updatedRecipe);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        Recipe updated = recipeService.editRecipe(recipe);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable("id") int id) {
        return recipeService.removeRecipe(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

