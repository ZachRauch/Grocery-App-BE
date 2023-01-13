package net.yorksolutions.zachrauchpantrybe.repositories;

import net.yorksolutions.zachrauchpantrybe.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Iterable<Recipe> findAllRecipesByUserId(Long userId);
}
