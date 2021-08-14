package dao;

import java.util.HashMap;
import java.util.Map;
import model.User;

public class UserDatabase {

    /**
     * Hold database instance
     */
    private static UserDatabase _instance;
    /**
     * Hold users data
     */
    private final Map<String, User> userTable = new HashMap<>();

    private UserDatabase() {
    }

    /**
     * getUserTable
     *
     * @return user data map
     */
    public Map<String, User> getUserTable() {
        return userTable;
    }

    /**
     * getInstance
     *
     * @return database instance
     *
     * Use singleton design pattern
     */
    public static UserDatabase getInstance() {
        if (_instance == null) {
            _instance = new UserDatabase();
        }
        return _instance;
    }

}
