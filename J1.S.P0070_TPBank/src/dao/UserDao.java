package dao;

import model.User;

public class UserDao {

    public User getUser(User user) {
        UserDatabase database = UserDatabase.getInstance();
        return database.getUserTable()
                .get(user.getUsername());
    }

    public boolean addUser(User user) {
        UserDatabase database = UserDatabase.getInstance();
        if (database.getUserTable().containsKey(user.getUsername())) {
            return false;
        }
        database.getUserTable().put(user.getUsername(), user);
        return true;
    }

}
