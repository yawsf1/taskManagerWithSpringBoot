package com.testing.task.user;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.save(user);
    }
    public void modifyUser(Long id, User user){
        User oldUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        oldUser.setNom(user.getNom());
        oldUser.setAge(user.getAge());
        userRepository.save(oldUser);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
