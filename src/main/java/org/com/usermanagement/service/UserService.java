package org.com.usermanagement.service;

import org.com.usermanagement.dto.UserResponce;
import org.com.usermanagement.exception.UserNotFoundException;
import org.com.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    public final UserRepository userRepository;

    public UserResponce getUserById(int id){
        if (id <= 0) {
            throw new UserNotFoundException("Invalid user id");
        }

        UserResponce user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }


}
