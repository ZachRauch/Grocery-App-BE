package net.yorksolutions.zachrauchpantrybe.services;

import net.yorksolutions.zachrauchpantrybe.models.Recipe;
import net.yorksolutions.zachrauchpantrybe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public Iterable<Recipe> getRecipesByUserId(Long userId) {
        return recipeRepository.findAllRecipesByUserId(userId);
    }

    public Recipe addRecipe(Recipe recipe) {
        return this.recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Long id, Recipe recipe) throws Exception {
        if (recipeRepository.existsById(id)) {
            return recipeRepository.save(recipe);
        } else throw new Exception("Invalid recipe");
    }

    public void deleteRecipe(Long id) {
        this.recipeRepository.deleteById(id);
    }
}
