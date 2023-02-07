package com.quack.squarestats.entity;

import com.quack.squarestats.dto.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class UserEntity {
    @Id
    private UUID uuid;

    private int wins;

    private int loses;

    public static UserEntity from(UserDTO userDTO){
        return new UserEntity().setUuid(userDTO.uuid()).setLoses(0).setWins(0);
    }

    public UUID getUuid() {
        return uuid;
    }

    public UserEntity setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public int getWins() {
        return wins;
    }

    public UserEntity setWins(int wins) {
        this.wins = wins;
        return this;
    }

    public int getLoses() {
        return loses;
    }

    public UserEntity setLoses(int loses) {
        this.loses = loses;
        return this;
    }
}
