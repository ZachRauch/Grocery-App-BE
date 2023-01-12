package net.yorksolutions.zachrauchpantrybe.repositories;

import net.yorksolutions.zachrauchpantrybe.models.Items;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemsRepository extends CrudRepository<Items, Long> {
    Optional<Items> findByNameAndUserId(String name, Long userId);

    Iterable<Items> findByUserId(Long userId);
}
