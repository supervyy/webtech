package WebTech.Webtech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Recipe {
 private long recipeId;
 private String recipeName;
 private String recipeCategory;
 private String ingredients;
 private String recipeDescription;
 private String recipeAuthor;
 // private String recipeImage;
}
