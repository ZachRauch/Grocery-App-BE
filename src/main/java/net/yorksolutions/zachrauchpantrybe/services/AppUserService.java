package net.yorksolutions.zachrauchpantrybe.services;

import net.yorksolutions.zachrauchpantrybe.models.AppUser;
import net.yorksolutions.zachrauchpantrybe.repositories.AppUserRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    final AppUserRepository appUserRepository;

    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser addUser(AppUser appUser) throws Exception {
        if (appUserRepository.findByEmail(appUser.email).isPresent()) {
            throw new Exception("The email you entered is already associated with an existing account");
        }
        return this.appUserRepository.save(appUser);
    }

    public void deleteUser(String email, String password) throws Exception {
        if (appUserRepository.findAppUserByEmailAndPassword(email, password).isPresent()) {
            appUserRepository.deleteById(appUserRepository.findByEmail(email).get().userId);
        } else throw new Exception("Cannot delete other Users");
    }

    public AppUser updateAppUser(AppUser appUser, String email) throws Exception {
        if (appUser.email.equals(email)) {
            return appUserRepository.save(appUser);
        }
        if (appUserRepository.findByEmail(appUser.email).isEmpty()) {
            return appUserRepository.save(appUser);
        } else throw new Exception("Cannot update User, the email you entered is already associated with an existing account");
    }

    public AppUser checkCredentials(String email, String password) {
        return appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow();
    }
}
