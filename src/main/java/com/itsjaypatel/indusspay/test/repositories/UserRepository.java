package com.itsjaypatel.indusspay.test.repositories;

import com.itsjaypatel.indusspay.test.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailOrPhone(String email, String phone);
}
