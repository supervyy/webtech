package WebTech.Webtech.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
public class Recipe {
 private long id;
 private String name;
 private String description;
 private String recipeImage;
 private String recipeCategory;
 private String ingredients;
 private String instructions;
 private String recipeAuthor;
 
}
