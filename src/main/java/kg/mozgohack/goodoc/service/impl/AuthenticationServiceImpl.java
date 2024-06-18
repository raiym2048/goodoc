package kg.mozgohack.goodoc.service.impl;

import kg.mozgohack.goodoc.dto.AuthenticationRequest;
import kg.mozgohack.goodoc.dto.AuthenticationResponse;
import kg.mozgohack.goodoc.dto.user.RegisterRequest;
import kg.mozgohack.goodoc.dto.user.UserResponse;
import kg.mozgohack.goodoc.entities.User;
import kg.mozgohack.goodoc.enums.Role;
import kg.mozgohack.goodoc.exception.BadCredentialsException;
import kg.mozgohack.goodoc.exception.NotFoundException;
import kg.mozgohack.goodoc.repository.UserRepository;
import kg.mozgohack.goodoc.security.JwtService;
import kg.mozgohack.goodoc.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public void register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent())
            throw new BadCredentialsException("this email is already exist!");
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(Role.CLIENT);
        userRepository.save(user);

    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        Optional<User> optionalAuth = userRepository.findByEmail(request.getEmail());

        if (optionalAuth.isEmpty()) {
            throw new NotFoundException("User not found with email or nickname: " + request.getEmail(), HttpStatus.BAD_GATEWAY);
        }
//        if (optionalAuth.get().getCheckCode() == -99)
//            throw new BadCredentialsException("the user do not access the code");

        User auth = optionalAuth.get();

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    auth.getEmail(),
                    request.getPassword()));

            // Set the authentication result into the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            System.out.println("Success auth");
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Bad credentials");
        }

        Map<String, Object> extraClaims = new HashMap<>();

        String token = jwtService.generateToken(extraClaims, auth);


        return AuthenticationResponse.builder()
                .user(convertToUserResponse(auth))
                .accessToken(token)
                .build();
    }

    private UserResponse convertToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());

        userResponse.setEmail(user.getEmail());
        userResponse.setRole(user.getRole());
        return userResponse;
    }

}
