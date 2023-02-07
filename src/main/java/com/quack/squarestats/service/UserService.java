package com.quack.squarestats.service;

import com.quack.squarestats.dto.UserDTO;
import com.quack.squarestats.entity.UserEntity;

import java.util.Collection;
import java.util.UUID;

public interface UserService {

    /**
     * Gets a user by its UUID
     * @param uuid
     * @return UserEntity
     */
    UserEntity getUserByUUID(UUID uuid);

    /**
     * Adds a new user from a UserDTO
     * @param userDTO
     * @return The newly saved UserEntity
     */
    UserEntity addUser(UserDTO userDTO);

    /**
     * Adds a new user from a UserEntity
     * @param userEntity
     * @return The newly saved UserEntity
     */
    UserEntity addUser(UserEntity userEntity);

    Collection<UserEntity> getUsers();

    /**
     * Updates a specific player's wins, number can be negative or positive
     * @param uuid The user's uuid
     * @param modifier The wins modifier
     * @return The new user with the wins updated
     */
    UserEntity updateWins(UUID uuid, int modifier);

    /**
     * Updates a specific player's loses count, number can be negative or positive
     * @param uuid The user's uuid
     * @param modifier The loses count modifier
     * @return The new user with the loses count updated
     */
    UserEntity updateLoses(UUID uuid, int modifier);

    int getUserLoses(UUID uuid);

    int getUserWins(UUID uuid);
}
