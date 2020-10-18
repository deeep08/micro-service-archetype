package db.example.remote.service;

import db.example.remote.dom.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    User getUser(long id);

}
