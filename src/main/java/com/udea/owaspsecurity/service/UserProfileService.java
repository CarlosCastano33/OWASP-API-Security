package com.udea.owaspsecurity.service;

import com.udea.owaspsecurity.entity.UserProfile;
import com.udea.owaspsecurity.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Autowired
    public UserProfileService(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    public UserProfile findByUserId(Long userId) {
        return userProfileRepository.findByIdUser(userId);
    }
}

