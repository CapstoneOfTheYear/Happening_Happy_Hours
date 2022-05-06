//package com.capstone.happening_happy_hours.services;
//import com.capstone.happening_happy_hours.models.User;
//import com.capstone.happening_happy_hours.models.UserWithRoles;
//import com.capstone.happening_happy_hours.repositories.UserRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//@Service
//public class UserDetailsLoader implements UserDetailsService {
//    private final UserRepository users;
//
//    public UserDetailsLoader(UserRepository users) {
//        this.users = users;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = users.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("No user found for " + username);
//        }
//
//        return new UserWithRoles(user);
//    }
//}