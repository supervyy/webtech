package WebTech.Webtech.service;

import WebTech.Webtech.entity.Recipe;
import WebTech.Webtech.repository.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private IRecipeRepository irecipeRepository;

    public RecipeService(IRecipeRepository irecipeRepository) {
        this.irecipeRepository = irecipeRepository;
    }

    public Iterable<Recipe> getAllRecipes() {
        return this.irecipeRepository.findAll();
    }
    public Iterable<Recipe> getRecipesByCategory(String category) {
        return this.irecipeRepository.findRecipeByCategory(category);
    }
    public Iterable<Recipe> getRecipesByName(String name) {
        return this.irecipeRepository.findRecipeByName(name);
    }

    public Iterable<Recipe> getLikedRecipes() {
        return irecipeRepository.findRecipeByFavorite(true);
    }

    public Optional<Recipe> getRecipeById(final int id) {
        return this.irecipeRepository.findById(id);
    }

    public Recipe addRecipe(final Recipe recipe) {
        return this.irecipeRepository.save(recipe);
    }

    public Recipe editRecipe(final Recipe recipe) {
        if (!this.irecipeRepository.existsById(recipe.getId())) return null;

        return addRecipe(recipe);
    }

    public boolean removeRecipe(final int id) {
        final boolean exists = this.irecipeRepository.existsById(id);
        if (exists) this.irecipeRepository.deleteById(id);
        return exists;
    }
}
