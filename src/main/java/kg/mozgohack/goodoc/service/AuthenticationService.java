package kg.mozgohack.goodoc.service;

import kg.mozgohack.goodoc.dto.AuthenticationRequest;
import kg.mozgohack.goodoc.dto.AuthenticationResponse;
import kg.mozgohack.goodoc.dto.user.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest request);

    AuthenticationResponse login(AuthenticationRequest request);
}
