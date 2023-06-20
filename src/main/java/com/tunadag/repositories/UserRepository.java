package com.tunadag.repositories;

import com.tunadag.repositories.base.BaseRepository;
import com.tunadag.repositories.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.state = 'ACTIVE' AND u.email = ?1")
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.state = 'ACTIVE' AND u.email IN ?1")
    List<User> findAllByEmails(List<String> emails);

    @Query(value = "SELECT * FROM users WHERE state = 'ACTIVE' AND oid IN (SELECT users_oid FROM users_roles WHERE roles_oid = (SELECT oid FROM roles WHERE role = 'MANAGER')) ORDER BY email", nativeQuery = true)
    List<User> findManagers();

    @Query(value = "SELECT * FROM users WHERE state = 'ACTIVE' AND oid IN (SELECT users_oid FROM users_roles WHERE roles_oid = (SELECT oid FROM roles WHERE role = 'ADMIN')) ORDER BY email", nativeQuery = true)
    List<User> findAdmins();
}
