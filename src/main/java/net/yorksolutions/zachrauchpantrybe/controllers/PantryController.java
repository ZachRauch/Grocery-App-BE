package net.yorksolutions.zachrauchpantrybe.controllers;

import net.yorksolutions.zachrauchpantrybe.models.Pantry;
import net.yorksolutions.zachrauchpantrybe.services.PantryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/pantry")
public class PantryController {

    public PantryService pantryService;

    public PantryController(PantryService pantryService) {
        this.pantryService = pantryService;
    }

    @GetMapping
    public Pantry getPantry(@RequestParam Long userId) {
        try {
            return pantryService.getPantry(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Pantry addPantry(@RequestBody Pantry pantry) {
        try {
            return pantryService.addPantry(pantry);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public Pantry updatePantry(@RequestBody Pantry pantry) {
        try {
            return pantryService.updatePantry(pantry);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    public void deletePantry(@PathVariable Long userId) {
        try {
            pantryService.deletePantry(userId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
