package util;

import java.util.Scanner;

public final class InputUtil {

    /**
     * getInputByRegex
     *
     * @param sc
     * @param REGEX
     * @param error
     * @return validated string
     *
     * Check user input by format
     */
    public static final String getInputByRegex(Scanner sc, String REGEX, String error) {
        String s;
        while (true) {
            s = sc.nextLine();
            if (!s.matches(REGEX)) {
                System.err.println(error);
                continue;
            }
            break;
        }
        return s;
    }

}
