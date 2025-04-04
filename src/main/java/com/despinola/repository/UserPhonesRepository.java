package com.despinola.repository;

import com.despinola.entities.UserPhonesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserPhonesRepository extends JpaRepository<UserPhonesEntity, UUID> {
    UserPhonesEntity findByNumber(String number);
}
