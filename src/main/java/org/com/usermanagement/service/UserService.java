package org.com.usermanagement.service;

import org.com.usermanagement.dto.UserRequest;
import org.com.usermanagement.dto.UserResponce;
import org.com.usermanagement.exception.UserNotFoundException;
import org.com.usermanagement.repository.UserRepository;
//import org.com.usermanagement.repository.UserRepositoryHardCOde;
import org.com.usermanagement.userEntity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Service
public class UserService {

    public final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }

/*    public UserResponce getUserById(int id){
        if (id <= 0) {
            throw new UserNotFoundException("Invalid user id");
        }

        UserResponce user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }*/



    public UserResponce getUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return  new UserResponce(user.getId(),
                user.getName(),
                user.getEmail()
        );


    }

    public UserResponce createUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEMail());

        User savedUser = userRepository.save(user);

        return new UserResponce(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );


    }


    public UserResponce updateUser(Long id, UserRequest request){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));


        user.setName(request.getName());
        user.setEmail(request.getEMail());

        User updatedUser = userRepository.save(user);

        return new UserResponce(
                updatedUser.getId(),
                updatedUser.getName(),
                updatedUser.getEmail()
        );
    }

    public void deleteUser(Long id){

        if (!userRepository.existsById(id)){
            throw new UserNotFoundException("User not found");
        }

        userRepository.deleteById(id);
    }

    public List<UserResponce> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponce(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                )).toList();
    }

}
