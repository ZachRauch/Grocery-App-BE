package net.yorksolutions.zachrauchpantrybe.repositories;

import net.yorksolutions.zachrauchpantrybe.models.ShoppingList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends CrudRepository<ShoppingList, Long> {
    ShoppingList findShoppingListByUserId(Long userId);

    void deleteByUserId(Long userId);
}
