package WebTech.Webtech.repository;

import WebTech.Webtech.entity.Recipe;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RecipeRepository {

    private  List<Recipe> recipes = new ArrayList<>();

    public List<Recipe> findAll(){
        return recipes;

    }
    //public Recipe findById(int id){

    //}
    @PostConstruct
    private void init(){
    recipes.add(new Recipe(1, "Korean Fried Chicken", "Crispy and flavorful chicken with a spicy glaze",
     "https://i.pinimg.com/736x/7f/4e/54/7f4e542859a08ac78396d4d63ccd7a10.jpg",
     "Appetizers", 
     "1 kg Chicken, 1 cup Flour, 1 tsp Salt, 1/2 tsp Pepper, Oil for frying, 2 tbsp Soy Sauce, 2 tbsp Sugar, 2 tbsp Rice Vinegar, 2 tbsp Gochujang, 2 tbsp Honey, 2 cloves Garlic, 1 tsp Ginger, Green Onions, Sesame Seeds", 
     "1. Cut chicken into bite-sized pieces. 2. Season chicken with salt and pepper. 3. Coat chicken in flour. 4. Fry chicken in oil until golden brown. 5. Make sauce by combining soy sauce, sugar, rice vinegar, gochujang, honey, garlic, and ginger. 6. Toss the fried chicken in the sauce. 7. Garnish with green onions and sesame seeds.",
     "John Doe"));
                
    recipes.add(new Recipe(2, "Spaghetti Carbonara", "Classic Italian pasta dish with bacon and eggs",
    "https://i.pinimg.com/736x/fe/07/27/fe072747470c09eeadfcac3f450a130e.jpg",
    "Main Course",
    "200g Spaghetti, 100g Pancetta, 2 Eggs, 1/2 cup Parmesan Cheese, 1/2 cup Pecorino Cheese, 2 cloves Garlic, Salt, Pepper, Parsley",
    "1. Cook spaghetti in salted water. 2. Fry pancetta in a pan. 3. Whisk eggs, parmesan, and pecorino in a bowl. 4. Add garlic to the pancetta. 5. Add cooked spaghetti to the pan. 6. Add egg mixture to the pan. 7. Toss everything together. 8. Season with salt and pepper. 9. Garnish with parsley.",
    "Noobanh"));

    recipes.add(new Recipe(3, "Matcha Latte", "Green tea latte made with matcha powder", "https://i.pinimg.com/736x/3d/f0/38/3df0387ca10b830837f1bf2f80559762.jpg",
    "Drinks", "1 tsp Matcha Powder, 1 cup Milk, 1 tbsp Sugar", 
    "1. Mix matcha powder with a little hot water. 2. Heat milk in a saucepan. 3. Add sugar to the milk. 4. Pour the milk into the matcha mixture. 5. Stir well",
    "Anyu"));

    recipes.add(new Recipe(4, "Tiramisu", "Classic Italian dessert made with coffee and mascarpone cheese",
     "https://i.pinimg.com/736x/eb/67/cd/eb67cdd4329512df261dcde1dce229f9.jpg",
     "Desserts", "1 cup Espresso, 1/2 cup Sugar, 1/4 cup Marsala Wine, 1 cup Mascarpone Cheese, 1 cup Whipped Cream, 1 pack Ladyfingers, Cocoa Powder", 
     "1. Mix espresso, sugar, and marsala wine. 2. Dip ladyfingers in the espresso mixture. 3. Layer the ladyfingers in a dish. 4. Mix mascarpone cheese and whipped cream. 5. Spread the cheese mixture over the ladyfingers. 6. Repeat the layers. 7. Dust with cocoa powder.",
     "Noobanh"));
    }





}
