package kg.mozgohack.goodoc.service.impl;

import kg.mozgohack.goodoc.entities.User;
import kg.mozgohack.goodoc.exception.BadCredentialsException;
import kg.mozgohack.goodoc.repository.UserRepository;
import kg.mozgohack.goodoc.service.UserService;
import lombok.AllArgsConstructor;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUsernameFromToken(String token) {

        String[] chunks = token.substring(7).split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        JSONParser jsonParser = new JSONParser();
        JSONObject object = null;
        try {
            object = (JSONObject) jsonParser.parse(decoder.decode(chunks[1]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Optional<User> user = userRepository.findByEmail(String.valueOf(object.get("sub")));
        if (user.isEmpty())
            throw new BadCredentialsException("No user in database with ur token! ReLogIn pls");
        return user.get();
    }

}
