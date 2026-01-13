package org.com.usermanagement.repository;

import org.com.usermanagement.userEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
