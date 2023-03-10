package net.yorksolutions.zachrauchpantrybe.controllers;

import net.yorksolutions.zachrauchpantrybe.models.AppUser;
import net.yorksolutions.zachrauchpantrybe.services.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class AppUserController {

    AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping
    public AppUser addUser(@RequestBody AppUser appUser) {
        try {
            return this.appUserService.addUser(appUser);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping
    public void deleteUser(@RequestParam String email, @RequestParam String password) {
        try {
            this.appUserService.deleteUser(email, password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping
    public AppUser updateAppUser(@RequestParam String email, @RequestBody AppUser appUser) {
        try {
            return appUserService.updateAppUser(appUser, email);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(params = {"email", "password"})
    public AppUser checkCredentials(@RequestParam String email, @RequestParam String password) {
        try {
            return appUserService.checkCredentials(email, password);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
