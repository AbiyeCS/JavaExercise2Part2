package org.example.javaexercise2part2.Service;

import jakarta.annotation.PostConstruct;
import org.example.javaexercise2part2.Repository.UserRepository;
import org.example.javaexercise2part2.model.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initialiseStudentData(){
        if(userRepository.count() == 0){
            List<User> allUsers = Arrays.asList(
                    new User("Zino","Checking123","Zino@email.com",27),
                    new User("Alex", "Password123", "alex.rivera@email.com", 24),
                    new User("Maya", "SecurePass456", "maya.chen@email.com", 31),
                    new User("Jordan", "MySecret789", "jordan.smith@email.com", 28),
                    new User("Sofia", "StrongKey101", "sofia.martinez@email.com", 22),
                    new User("Kai", "SafeWord202", "kai.johnson@email.com", 35),
                    new User("Luna", "Protected303", "luna.davis@email.com", 29),
                    new User("Ethan", "Guardian404", "ethan.wilson@email.com", 26),
                    new User("Zara", "Fortress505", "zara.brown@email.com", 33),
                    new User("Diego", "Shield606", "diego.garcia@email.com", 25),
                    new User("Aria", "Vault707", "aria.taylor@email.com", 30),
                    new User("Felix", "Cipher808", "felix.anderson@email.com", 27),
                    new User("Nova", "Keystone909", "nova.white@email.com", 23),
                    new User("Rio", "Bastion111", "rio.thompson@email.com", 32),
                    new User("Ivy", "Sentinel222", "ivy.martinez@email.com", 28),
                    new User("Asher", "Bulwark333", "asher.lee@email.com", 34),
                    new User("Sage", "Rampart444", "sage.clark@email.com", 26),
                    new User("Phoenix", "Citadel555", "phoenix.rodriguez@email.com", 29),
                    new User("Orion", "Stronghold666", "orion.lewis@email.com", 31),
                    new User("Echo", "Firewall777", "echo.walker@email.com", 24),
                    new User("Atlas", "Irongate888", "atlas.hall@email.com", 36)
            );
            userRepository.saveAll(allUsers);
            System.out.println("User Data initialized!");
        }
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username).get();
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).get();
    }

    public List<User> findAllByAgeAfter(int age){
        return userRepository.findAllByAgeAfter(age);
    }
}
