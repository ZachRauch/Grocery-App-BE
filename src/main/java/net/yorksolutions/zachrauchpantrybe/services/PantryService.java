package net.yorksolutions.zachrauchpantrybe.services;

import net.yorksolutions.zachrauchpantrybe.models.Pantry;
import net.yorksolutions.zachrauchpantrybe.repositories.PantryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PantryService {

    PantryRepository pantryRepository;

    public PantryService(PantryRepository pantryRepository) {
        this.pantryRepository = pantryRepository;
    }

    public Pantry getPantry(Long userId) throws Exception {
        return pantryRepository.findPantryByUserId(userId).orElseThrow();
    }

    public Pantry addPantry(Pantry pantry) {
        return pantryRepository.save(pantry);
    }

    public Pantry updatePantry(Pantry pantry) throws Exception {
        if (pantryRepository.findPantryByUserId(pantry.userId).isEmpty()) throw new Exception();

        final var updatedPantry = pantryRepository.findPantryByUserId(pantry.userId).orElseThrow();
        updatedPantry.userId = pantry.userId;
        updatedPantry.items = pantry.items;

        return pantryRepository.save(updatedPantry);
    }

    public void deletePantry(Long userId) throws Exception {
        if (this.pantryRepository.findPantryByUserId(userId).isPresent()) {
            pantryRepository.deletePantryByUserId(userId);
        } else throw new Exception();
    }
}
