package net.yorksolutions.zachrauchpantrybe.repositories;

import net.yorksolutions.zachrauchpantrybe.models.Pantry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PantryRepository extends CrudRepository<Pantry, Long> {
    Optional<Pantry> findPantryByUserId(Long userId);

    void deletePantryByUserId(Long userId);

    Optional<Pantry> findByUserId(Long userId);
}
