package db.example.remote.service.impl;

import db.example.remote.dom.User;
import db.example.remote.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private static final String USER_SERVICE_URL = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    @Override
    public List<User> listUsers() {
        final User[] users = restTemplate.getForEntity(USER_SERVICE_URL, User[].class).getBody();
        return Arrays.asList(Objects.requireNonNullElseGet(users, () -> new User[0]));
    }

    @Override
    public User getUser(long id) {
        return restTemplate.getForEntity(USER_SERVICE_URL + "/" + id, User.class).getBody();
    }
}
