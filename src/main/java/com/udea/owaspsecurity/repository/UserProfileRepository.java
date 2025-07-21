package com.udea.owaspsecurity.repository;

import com.udea.owaspsecurity.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    UserProfile findByIdUser(Long idUser);
    UserProfile findByName(String name);
}

