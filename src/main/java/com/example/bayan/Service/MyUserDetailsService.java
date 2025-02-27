package com.example.bayan.Service;

import com.example.bayan.Api.ApiException;
import com.example.bayan.Model.MyUser;
import com.example.bayan.Repostiry.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class MyUserDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;

    public MyUserDetailsService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser myUser = authRepository.findMyUserByUsername(username);

        if (myUser == null) throw new ApiException("Wrong username or password");

        return myUser;

    }
}
