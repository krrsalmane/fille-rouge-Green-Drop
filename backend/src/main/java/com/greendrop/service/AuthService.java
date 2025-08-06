package com.greendrop.service;
import com.greendrop.dto.AuthRequestDTO;
import com.greendrop.dto.AuthResponseDTO;
import com.greendrop.dto.RegisterRequestDTO;
import com.greendrop.model.User;
import com.greendrop.model.Agriculteur;
import com.greendrop.model.Role;
import com.greendrop.repository.UserRepository;
import com.greendrop.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository utilisateurRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    // Registration Logic (no changes)
    public void register(RegisterRequestDTO request) {
        if (utilisateurRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        if (request.getRole() == Role.ADMIN) {
            User user = new User();
            user.setNom(request.getNom());
            user.setPrenom(request.getPrenom());
            user.setEmail(request.getEmail());
            user.setPassword(hashedPassword);
            user.setRole(Role.ADMIN);
            utilisateurRepository.save(user);
        } else {
            Agriculteur user = new Agriculteur();
            user.setNom(request.getNom());
            user.setPrenom(request.getPrenom());
            user.setEmail(request.getEmail());
            user.setPassword(hashedPassword);
            user.setTelephone(request.getTelephone());
            user.setRole(Role.AGRICULTEUR);
            utilisateurRepository.save(user);
        }
    }

    // Simplified Login Logic
    public AuthResponseDTO login(AuthRequestDTO request) {
        // 1. Check if the user exists and the password is correct
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 2. If successful, find the user and generate a token
        UserDetails user = utilisateurRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user.getUsername());

        // 3. Return the token
        return new AuthResponseDTO(token);
    }
}
