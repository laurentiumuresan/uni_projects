package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
    private OnlineStore store = new OnlineStore();
    private Set<User> users = new HashSet<>();
    public LoginSystem() {
    }

    public LoginSystem(OnlineStore store, Set<User> users) {
        this.store = store;
        this.users = users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setStore(OnlineStore store) {
        this.store = store;
    }

    public Set<User> getUsers() {
        return users;
    }

    public OnlineStore getStore() {
        return store;
    }

    public boolean logout(String username) {
        return true;
    }

    public void register(String username, String password) {
        User user = new User(username, password);
        users.add(user);
    }

    public boolean logIn(String username, String password) {
        store.addSession(username);
        for (User u : users) {
            if (u.getUsername() == username && u.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public boolean logOut(String username) {
        store.removeSession(username);
        return true;
    }

}
