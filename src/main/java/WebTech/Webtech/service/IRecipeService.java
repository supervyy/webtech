package WebTech.Webtech.service;

import WebTech.Webtech.entity.Recipe;

import java.util.List;

public interface IRecipeService {
    List<Recipe> findAllRecipes();
    // Recipe findRecipeById(int id);
    // deleteRecipe(long Id);
    // addRecipe();
    // updateRecipe();
}
