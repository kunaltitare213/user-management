package org.com.usermanagement.repository;

import org.com.usermanagement.dto.UserResponce;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public UserResponce findById(int id){
        if (id == 1) {
            return new UserResponce(1, "Kunal");
        }
        return null;
    }
}
