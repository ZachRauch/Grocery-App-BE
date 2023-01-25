package net.yorksolutions.zachrauchpantrybe.controllers;

import net.yorksolutions.zachrauchpantrybe.models.Items;
import net.yorksolutions.zachrauchpantrybe.services.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/items")
public class ItemsController {

    ItemsService itemsService;

    public ItemsController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @PostMapping
    public Items addItem(@RequestBody Items items) {
        try {
            return this.itemsService.addItems(items);
        } catch (Exception e) {
            throw new ResponseStatusException((HttpStatus.BAD_REQUEST), e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        try {
            this.itemsService.deleteItem(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Items updateItem(@PathVariable Long id, @RequestBody Items items) {
        try {
            return itemsService.updateItem(id, items);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping
    public Iterable<Items> getAllItems() {
        return this.itemsService.getAllItems();
    }

}
