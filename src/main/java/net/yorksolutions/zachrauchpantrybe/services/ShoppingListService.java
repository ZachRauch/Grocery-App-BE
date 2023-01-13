package net.yorksolutions.zachrauchpantrybe.services;

import net.yorksolutions.zachrauchpantrybe.models.ShoppingList;
import net.yorksolutions.zachrauchpantrybe.repositories.ShoppingListRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    ShoppingListRepository shoppingListRepository;

    public ShoppingListService(ShoppingListRepository shoppingListRepository) {
        this.shoppingListRepository = shoppingListRepository;
    }

    public ShoppingList findShoppingList(Long userId) {
        return shoppingListRepository.findShoppingListByUserId(userId);
    }

    public ShoppingList updateShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList addShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public void deleteShoppingList(Long userId) {
        shoppingListRepository.deleteByUserId(userId);
    }
}
