package net.yorksolutions.zachrauchpantrybe.controllers;

import net.yorksolutions.zachrauchpantrybe.models.ShoppingList;
import net.yorksolutions.zachrauchpantrybe.services.ShoppingListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/shopping-lists")
public class ShoppingListController {

    ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping
    public ShoppingList getShoppingList(@RequestParam Long userId) {
        try {
            return shoppingListService.findShoppingList(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ShoppingList updateShoppingList(@RequestBody ShoppingList shoppingList) {
        try {
            return shoppingListService.updateShoppingList(shoppingList);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ShoppingList addShoppingList(@RequestBody ShoppingList shoppingList) {
        try {
            return shoppingListService.addShoppingList(shoppingList);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteShoppingList(@PathVariable Long userId) {
        shoppingListService.deleteShoppingList(userId);
    }
}
