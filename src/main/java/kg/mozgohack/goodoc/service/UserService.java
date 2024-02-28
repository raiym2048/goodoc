package kg.mozgohack.goodoc.service;

import kg.mozgohack.goodoc.entities.User;

public interface UserService {
    User getUsernameFromToken(String token);
}
