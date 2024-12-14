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

    public Iterable<Recipe> findAllRecipes() {
        return this.irecipeRepository.findAll();
    }

    public Optional<Recipe> findRecipe(final int id) {
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
