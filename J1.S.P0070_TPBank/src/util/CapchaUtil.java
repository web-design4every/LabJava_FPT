package util;

import java.util.Random;

public class CapchaUtil {

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random rd = new Random();
        int counter = 0;
        while (true) {
            int x = rd.nextInt(105) + 20;
            boolean inRange
                    = ((x >= 49 && x <= 57)
                    || (x >= 65 && x <= 89)
                    || (x >= 97 && x <= 122));
            if (!inRange) {
                continue;
            }
            sb.append(String.valueOf((char) x));
            if (counter == length) {
                break;
            }
            counter++;
        }
        return sb.toString();
    }
}
