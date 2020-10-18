package com.caerkea.searchuser.Service;

import com.caerkea.searchuser.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    public UserService() {
        createUsers();
    }

    public List<User> findUsers(String name) {
        List<User> results = new ArrayList<>();
        for (User u: users) {
            if (u.getUsername().startsWith(name)) {
                results.add(u);
            }
        }
        return results;
    }

    public void createUsers() {
        users.add(new User("Anna P"));
        users.add(new User("Anna S"));
        users.add(new User("Karl P"));
        users.add(new User("Svend P"));
    }
}
