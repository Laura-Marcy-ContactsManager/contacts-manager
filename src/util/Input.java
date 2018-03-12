package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner;


    public Input() {
        scanner = new Scanner(System.in);

    }

    public String getString() {
        return scanner.next();
    }

    public String getNextLine() {
        return scanner.nextLine();
    }


    public String getString(String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;

    }


    public boolean yesNo() {
        String userInput = getString();
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        return yesNo();
    }


    public int getInt(String prompt) {
        System.out.println(prompt);
        String intInput = scanner.nextLine();
        try {
            return Integer.valueOf(intInput);
        } catch (NumberFormatException e) {
            System.out.println("Error- Input number be an Integer!");
            return getInt(prompt);
        }
    }


    public int getInt(String prompt, int min, int max) {
        int userInt = getInt(prompt);
        if (userInt > max || userInt < min) {
            return getInt(prompt, min, max);
        } else {
            System.out.println("Error--Integer must be between" + min + " & " + max);
            return userInt;
        }
    }


    public double getDouble(String prompt) {
        System.out.println(prompt);
        String intDoubleInput = scanner.nextLine();
        try {
            return Double.valueOf(intDoubleInput);
        } catch (NumberFormatException e) {
            System.out.println("Error- Input number be an Integer!");
            return getDouble(prompt);
        }
    }

    public double getDouble(String prompt, double min, double max) {
        double number = getDouble(prompt);
        if (number < min || number > max) {
            System.out.println("Error--Integer must be between" + min + " & " + max);
            return getDouble(prompt, min, max);
        } else {

            return number;
        }
    }
}
