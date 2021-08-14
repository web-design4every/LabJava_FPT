package main;

import dao.UserDao;
import java.util.Scanner;
import mock.Mock;

public class Main {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        UserDao dao = new UserDao();
        Mock.createUser().values().forEach(e -> {
            dao.addUser(e);
        });
        Thread tpBank = new Thread(new TPBankApp(sc, dao));
        tpBank.start();
    }
}
