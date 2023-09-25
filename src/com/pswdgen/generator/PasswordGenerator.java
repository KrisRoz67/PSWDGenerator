package com.pswdgen.generator;

import java.util.Scanner;

public class PasswordGenerator {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PasswordGenerator passgen = new PasswordGenerator();
        System.out.println("Plase enter a number of symbols from 6-21");
        int numberOfSymbols = passgen.validatePassLength(scanner.next());
        System.out.println("Do you want use numeric password or alphabetic or mixed?");
        String typeOfPass = scanner.next();
        System.out.println("Do you want to use upper case?Answer option : Yes or no." );
        String answer = scanner.next().toLowerCase();
        String pass = passgen.generatePass(typeOfPass, numberOfSymbols,answer );
        System.out.println("Your pass is :"+ pass);

    }


    public String switchRegister( String pass, String answer) {
        try {
            if (answer == "no") {
                return pass.toLowerCase();

            } else if (answer == "yes") {
                return pass;

            }
        } catch (Exception e) {
            return switchRegister(pass, scanner.next());
        }
        return pass;
    }

    public int validatePassLength(String userinput) {
        try {
            int input = Integer.parseInt(userinput);
            if (input > 5 && input < 22) {
                return input;
            }
            System.out.println("Please insert only numbers from 6 to 21");
            return validatePassLength(scanner.next());

        } catch (Exception e) {
            System.out.println("Please insert only numbers from 6 to 21");
            return validatePassLength(scanner.next());

        }
    }

    public String generatePass(String userinput, int length, String answer) {
        String password = "";
        switch (userinput) {
            case "numeric":
                for (int i = 0; i < length; i++) {
                    password = password + String.valueOf((int) (Math.random() * 10));
                }
                return password;

            case "alphabetic":
                for (int i = 0; i < length; i++) {
                    String alphabet = "AaBbCcDdeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwSsXxYyZz";
                    password = password + alphabet.charAt((int) (Math.random() * alphabet.length()));
                }
                return switchRegister(password,answer);

            case "mixed":
                for (int i = 0; i < length; i++) {
                    String mixed = "0123456789AaBbCcDdeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwSsXxYyZz";
                    password = password + mixed.charAt((int) (Math.random() * mixed.length()));
                }
                return switchRegister(password,answer);

            default:
                System.out.println("ne popalo ni4ego");
        }
        return password;
    }
}
