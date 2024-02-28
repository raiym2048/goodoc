package kg.mozgohack.goodoc.controller;

import kg.mozgohack.goodoc.dto.AuthenticationRequest;
import kg.mozgohack.goodoc.dto.AuthenticationResponse;
import kg.mozgohack.goodoc.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public void register(@RequestBody AuthenticationRequest request){
        service.register(request);
    }
    @PostMapping("/login")
    public AuthenticationResponse response(@RequestBody AuthenticationRequest request){
        return service.login(request);
    }
}
