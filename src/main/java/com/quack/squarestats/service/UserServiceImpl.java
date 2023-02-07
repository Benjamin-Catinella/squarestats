package com.quack.squarestats.service;

import com.quack.squarestats.dto.UserDTO;
import com.quack.squarestats.entity.UserEntity;
import com.quack.squarestats.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserEntity getUserByUUID(UUID uuid){
        return this.userRepository.getByUuid(uuid);
    }

    @Override
    public UserEntity addUser(UserDTO userDTO){
        return userRepository.save(UserEntity.from(userDTO));
    }
    @Override
    public UserEntity addUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }
    @Override
    public Collection<UserEntity> getUsers() {
        return (Collection<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity updateWins(UUID uuid, int modifier) {
        UserEntity user = userRepository.getByUuid(uuid);
        return userRepository.save(user.setWins(user.getWins() + modifier));
    }
    @Override
    public UserEntity updateLoses(UUID uuid, int modifier) {
        UserEntity user = userRepository.getByUuid(uuid);
        return userRepository.save(user.setLoses(user.getLoses() + modifier));
    }

    @Override
    public int getUserLoses(UUID uuid) {
        return userRepository.getByUuid(uuid).getLoses();
    }

    @Override
    public int getUserWins(UUID uuid) {
        return userRepository.getByUuid(uuid).getWins();
    }

}
