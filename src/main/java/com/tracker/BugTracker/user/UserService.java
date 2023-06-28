package com.tracker.BugTracker.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public void saveUser(User user) {
//        User user = new User(userDto.getEmail(), bCryptPasswordEncoder.encode(userDto.getPassword()), Role.USER);
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(Role.USER);
        userRepo.save(user);
    }
    public List<Object> isUserPresent(User user) {
        boolean userExists = false;
        String message = null;
        Optional<User> existingUserEmail = userRepo.findByEmail((user.getEmail()));
        if (existingUserEmail.isPresent()) {
            userExists = true;
            message = "Email already exists";
        }
        return Arrays.asList(userExists, message);

    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email).orElseThrow(
                ()->new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", email)
                )
        );

    }
}
