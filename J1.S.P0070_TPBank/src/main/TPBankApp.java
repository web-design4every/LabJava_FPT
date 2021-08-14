package main;

import constant.Constant;
import constant.Lang;
import constant.Message;
import dao.UserDao;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import model.TpBankUser;
import model.User;
import util.CapchaUtil;
import util.InputUtil;

public final class TPBankApp implements Runnable {

    private ResourceBundle resourceBundle;
    private final Scanner sc;
    private final UserDao userDao;

    public TPBankApp(Scanner sc, UserDao userDao) {
        this.sc = sc;
        this.userDao = userDao;
        switchLanguage(Lang.ENGLISH);
    }

    /**
     * displayMenu
     */
    private void displayMenu() {
        System.out.println(resourceBundle.getString(Message.LOGIN_PROGRAM));
        System.out.println(String.format("%d. %s", 1, resourceBundle.getString(Message.VIETNAMESE)));
        System.out.println(String.format("%d. %s", 2, resourceBundle.getString(Message.ENGLISH)));
        System.out.println(String.format("%d: %s", 3, resourceBundle.getString("exit")));
        System.out.println(String.format("%s:", resourceBundle.getString(Message.PLEASE_CHOICE_ONE_OPTION)));
    }

    /**
     * switchLanguage
     *
     * @param lang
     */
    private void switchLanguage(String locale) {
        final String src = "resouces/language";
        Locale currLocale = new Locale(locale);
        resourceBundle = ResourceBundle.getBundle(src, currLocale);
    }

    /**
     * inputUsername
     *
     * @return validated username
     *
     * Check username by format
     */
    private String inputUsername() {
        System.out.println(String.format("%s:", resourceBundle.getString(Message.ACCOUNT_NUMBERR)));
        return InputUtil.getInputByRegex(sc, Constant.REGEX_USERNAME, resourceBundle.getString(Message.ACCOUNT_NUMBER_ERROR));
    }

    /**
     * inputPassword
     *
     * @return validated password
     *
     * Check password by format
     */
    private String inputPassword() {
        System.out.println(String.format("%s:", resourceBundle.getString(Message.PASSWORD)));
        return InputUtil.getInputByRegex(sc, Constant.REGEX_PASSWORD, resourceBundle.getString(Message.PASSWORD_ERROR_LENGTH));
    }

    /**
     * checkCapcha
     *
     * Check user input correct a part of system capcha
     */
    private void checkCapcha() {
        String capchaSystem = CapchaUtil.generateRandomString(4);
        System.out.println(String.format("%s:%s", resourceBundle.getString(Message.CAPCHA), capchaSystem));
        while (true) {
            String capchaInput = sc.nextLine();
            if (!capchaSystem.contains(capchaInput)) {
                System.err.println(resourceBundle.getString(Message.WRONG_CAPCHA));
                continue;
            }
            break;
        }
    }

    private void login() {
        String username = inputUsername();
        String password = inputPassword();
        checkCapcha();
        User user = new TpBankUser(username, password);
        User userDb = userDao.getUser(user);
        if (userDb == null) {
            System.err.println(resourceBundle.getString(Message.ACCOUNT_NUMBER_NOT_EXIST));
        } else if (user.getPassword().equals(userDb.getPassword())) {
            System.out.println(resourceBundle.getString(Message.LOGIN_SUCCESS));
        } else {
            System.err.println(resourceBundle.getString(Message.LOGIN_FAIL));
        }

    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    switchLanguage(Lang.VIETNAM);
                    login();
                    break;
                case "2":
                    switchLanguage(Lang.ENGLISH);
                    login();
                    break;
                case "3":
                    System.exit(0);
                    break;
            }
        }
    }

}
