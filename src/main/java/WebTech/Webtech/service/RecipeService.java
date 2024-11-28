package WebTech.Webtech.service;

import WebTech.Webtech.entity.Recipe;
import WebTech.Webtech.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeService implements IRecipeService {


    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }
    @Override
    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    //@Override
    //public Recipe findRecipeById(int id) {
    //    return null;
    //}
}
