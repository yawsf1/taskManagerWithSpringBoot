package com.testing.task.user;
import com.testing.task.exception.ApiRequestException;
import com.testing.task.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper){
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    public void addUser(UserRequest user){
        User realUser = userDTOMapper.toEntity(user);
        userRepository.save(realUser);
    }
    public void modifyUser(Long id, UserRequest user){
        User oldUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        User realUser = userDTOMapper.toEntity(user);
        oldUser.setNom(realUser.getNom());
        oldUser.setAge(realUser.getAge());
        userRepository.save(oldUser);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(userDTOMapper).collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id){
        return userRepository.findById(id).map(userDTOMapper).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
