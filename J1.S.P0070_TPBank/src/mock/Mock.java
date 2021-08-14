package mock;

import java.util.HashMap;
import java.util.Map;
import model.TpBankUser;
import model.User;

public class Mock {

    public static Map<String, User> createUser() {
        return new HashMap<String, User>() {
            {
                put("1234567890", new TpBankUser("1234567890", "duong123"));
                put("9876543210", new TpBankUser("9876543210", "duong123"));
                put("9999999999", new TpBankUser("9999999999", "duong123"));
                put("6969696969", new TpBankUser("6969696969", "duong123"));
            }
        };
    }
}
