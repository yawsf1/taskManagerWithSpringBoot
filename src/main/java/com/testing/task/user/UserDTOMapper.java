package com.testing.task.user;



import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserResponse> {
    @Override
    public UserResponse apply(User user) {
        return new UserResponse(user.getId(),  user.getAge(), user.getNom());
    }
    public User toEntity(UserRequest request) {
        User user = new User();
        user.setNom(request.nom());
        user.setAge(request.age());
        return user;
    }
}
