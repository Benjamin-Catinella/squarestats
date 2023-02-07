package com.quack.squarestats.controller;

import com.quack.squarestats.dto.UserDTO;
import com.quack.squarestats.entity.UserEntity;
import com.quack.squarestats.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Get a UserEntity from given UUID
     * @param uuid The UUID
     * @return UserEntity
     */
    @GetMapping("/users/{uuid}")
    public UserEntity getUser(@PathVariable("uuid") UUID uuid){
        return this.userService.getUserByUUID(uuid);
    }

    /**
     * Get All existing users
     * @return Collection of UserEntity
     */
    @GetMapping("/users")
    public Collection<UserEntity> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{uuid}/wins")
    public int getUserWins(@PathVariable("uuid") UUID uuid){
        return userService.getUserWins(uuid);
    }
    @GetMapping("/users/{uuid}/loses")
    public int getUserLoses(@PathVariable("uuid") UUID uuid){
        return userService.getUserLoses(uuid);
    }

    @PostMapping("/users")
    public UserEntity addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PutMapping("/users/{uuid}/wins")
    public UserEntity updateWins(@PathVariable("uuid") UUID uuid, @RequestBody int modifier){
        return userService.updateWins(uuid,modifier);
    }

    @PutMapping("/users/{uuid}/loses")
    public UserEntity updateLoses(@PathVariable("uuid") UUID uuid, @RequestBody int modifier) {
        return userService.updateLoses(uuid,modifier);
    }
}
