package net.yorksolutions.zachrauchpantrybe.controllers;

import net.yorksolutions.zachrauchpantrybe.models.Recipe;
import net.yorksolutions.zachrauchpantrybe.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping
public class RecipeController {

    RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public Recipe getRecipes(@RequestParam Long userId) {
        try {
            return recipeService.getRecipesByUserId(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        try {
            return recipeService.addRecipe(recipe);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable Long id, Recipe recipe) {
        try {
            return this.recipeService.updateRecipe(id, recipe);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipe(id);
    }
}
