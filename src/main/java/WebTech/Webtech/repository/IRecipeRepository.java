package WebTech.Webtech.repository;

import WebTech.Webtech.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface IRecipeRepository extends CrudRepository<Recipe, Integer> {
}
