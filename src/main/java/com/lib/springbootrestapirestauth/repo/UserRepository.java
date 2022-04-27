package com.lib.springbootrestapirestauth.repo;

import com.lib.springbootrestapirestauth.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
-- This Class
-   Repository, performs various operations on the object.
-   Find user by username
-   Access our user table in the database using repository.
 */

public interface UserRepository extends JpaRepository<ApiUser, Long> {
    Optional<ApiUser> findByUsername(String username);
}