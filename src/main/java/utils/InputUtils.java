package utils;

import java.util.Scanner;

public class InputUtils {
    public static char scanAndReturnFirstChar(Scanner scanner) {
        String input = scanner.nextLine();
        return input.isEmpty() ? '\0' : input.charAt(0);
    }
}