package com.greendrop.service;



import com.greendrop.dto.RegisterRequestDTO;
import com.greendrop.model.Administrator;
import com.greendrop.model.Agriculteur;
import com.greendrop.model.Role;
import com.greendrop.repository.AdministratorRepository;
import com.greendrop.repository.AgriculteurRepository;
import com.greendrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private AgriculteurRepository agriculteurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Spring Security's password hasher

    public void register(RegisterRequestDTO registerRequest) {
        // 1. Check if email already exists
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        // 2. Hash the password
        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());

        // 3. Create user based on role
        if (registerRequest.getRole() == Role.ADMIN) {
            Administrator admin = new Administrator();
            admin.setNom(registerRequest.getNom());
            admin.setPrenom(registerRequest.getPrenom());
            admin.setEmail(registerRequest.getEmail());
            admin.setPassword(hashedPassword);
            administratorRepository.save(admin);
        } else if (registerRequest.getRole() == Role.AGRICULTEUR) {
            Agriculteur agriculteur = new Agriculteur();
            agriculteur.setNom(registerRequest.getNom());
            agriculteur.setPrenom(registerRequest.getPrenom());
            agriculteur.setEmail(registerRequest.getEmail());
            agriculteur.setPassword(hashedPassword);
            agriculteur.setTelephone(registerRequest.getTelephone());
            agriculteurRepository.save(agriculteur);
        } else {
            throw new IllegalArgumentException("Invalid role specified");
        }
    }
}
