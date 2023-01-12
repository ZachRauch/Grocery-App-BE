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

    public void deleteUser(Long id, String email, String password) throws Exception {
        if (appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow().userId.equals(id)) {
            appUserRepository.deleteById(id);
        } else throw new Exception("Cannot delete other Users");
    }

    public AppUser updateAppUser(Long id, AppUser appUser, String email, String password) throws Exception {
        if (appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow().userId.equals(id)
                && appUserRepository.findByEmail(appUser.email).isEmpty()) {
            return appUserRepository.save(appUser);
        } else throw new Exception("Cannot update User, the email you entered is already associated with an existing account");
    }

    public AppUser checkCredentials(String email, String password) {
        return appUserRepository.findAppUserByEmailAndPassword(email, password).orElseThrow();
    }
}
