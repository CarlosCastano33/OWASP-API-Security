package com.udea.owaspsecurity.Controller;

import com.udea.owaspsecurity.entity.UserProfile;
import com.udea.owaspsecurity.repository.UserProfileRepository;
import com.udea.owaspsecurity.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private final UserProfileService userProfileService;
    private final UserProfileRepository userRepository;

    @Autowired
    public UserController(UserProfileService userProfileService, UserProfileRepository userRepository){
        this.userProfileService = userProfileService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users/{userId}/profile")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long userId) {
        UserProfile profile = userProfileService.findByUserId(userId);
        return ResponseEntity.ok(profile);
    }

    //VERSION CORREGIDA
    @GetMapping("/users2/{userId}/profile")
    public ResponseEntity<UserProfile> getUserProfile(
            @PathVariable Long userId,
            Authentication authentication) {

        String username = authentication.getName();
        UserProfile currentUser = userRepository.findByName(username);

        // Validar que el ID del path sea el del usuario autenticado
        if (!currentUser.getIdUser().equals(userId)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        // Obtener el perfil si está autorizado
        UserProfile profile = userProfileService.findByUserId(userId);
        return ResponseEntity.ok(profile);
    }


}
