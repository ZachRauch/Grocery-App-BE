package net.yorksolutions.zachrauchpantrybe.repositories;

import net.yorksolutions.zachrauchpantrybe.models.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

    Optional<AppUser> findAppUserByEmailAndPassword(String email, String password);
}
