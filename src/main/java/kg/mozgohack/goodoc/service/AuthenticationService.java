package kg.mozgohack.goodoc.service;

import kg.mozgohack.goodoc.dto.AuthenticationRequest;
import kg.mozgohack.goodoc.dto.AuthenticationResponse;

public interface AuthenticationService {
    void register(AuthenticationRequest request);

    AuthenticationResponse login(AuthenticationRequest request);
}
