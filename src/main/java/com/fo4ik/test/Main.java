

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    String name, password, age, email, address, nationality, phone;

    String[] strings = {name, password, age, email, address, nationality, phone};
    String[] stringsName = {"Name", "Password", "Age", "Email", "Address", "Nationality", "Phone"};

    List<String> userName = new ArrayList<>();
    HashMap<String, String> userPassword = new HashMap<>();
    HashMap<String, String> userEmail = new HashMap<>();
    HashMap<String, String> userAddress = new HashMap<>();
    HashMap<String, String> userNationality = new HashMap<>();
    HashMap<String, String> userAge = new HashMap<>();
    HashMap<String, String> userPhone = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login to account type 'l'");
        System.out.println("Register account type 'r'");

        try {
            switch (scanner.nextLine()) {
                case "l": {
                    login();
                } break;
                case "r": {
                    register();
                } break;
                default:
                    System.out.println("Wrong command");
                    menu();
            }
        } catch (Exception e) {
            System.out.println("Incorrect input, try again");
            menu();
        }
    }

    private void register() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < strings.length; i++) {
            System.out.println("Enter " + stringsName[i]);
            strings[i] = scanner.nextLine();
            if (i == 1) {
                checkPassword(strings[i]);
            }
        }

        for (int i = 0; i < strings.length; i++) {
            System.out.println("Your accaunt: \n" + stringsName[i] + ": " + strings[i]);
        }
        System.out.println("Do you want to save this account? (yes/no)");
        if (scanner.nextLine().equals("yes")) {
            saveData();
            System.out.println("Account saved");
            menu();
        } else menu();
    }

    private void saveData() {
        name = strings[0];
        password = strings[1];
        age = strings[2];
        email = strings[3];
        address = strings[4];
        nationality = strings[5];
        phone = strings[6];

        System.out.println("Saving data...");
        userName.add(name);
        userPassword.put(name, password);
        userAge.put(name, age);
        userEmail.put(name, email);
        userAddress.put(name, address);
        userNationality.put(name, nationality);
        userPhone.put(name, phone);
    }

    private void checkPassword(String password) {
        char[] charPassword = password.toCharArray();

        int count = 0;
        int count2 = 0;

        if (password.length() < 11) {
            System.out.println("Password must be at more 11 characters");
            register();
        } else {
            for (int i = 0; i < charPassword.length; i++) {
                if (Character.isUpperCase(charPassword[i])) {
                    count++;
                }
            }
            if (count < 1) {
                System.out.println("Password must contain at least 1 uppercase letters");
                count = 0;
                register();
            } else {
                for (int i = 0; i < charPassword.length; i++) {
                    Boolean flag = Character.isDigit(charPassword[i]);
                    if (flag) {
                        count++;
                        //number
                    } else {
                        count2++;
                        //letters
                    }
                }
                if (count < 3) {
                    System.out.println("Password must contain at least 3 numbers");
                    count = 0;
                    register();
                } else if (count2 < 2) {
                    System.out.println("Password must contain at least 2 letters");
                    count2 = 0;
                    register();
                }
            }
        }
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = scanner.nextLine();
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        if (userPassword.containsKey(name)) {
            if (userPassword.get(name).equals(password)) {
                System.out.println("Welcome " + name);
                System.out.println("Your age: " + userAge.get(name));
                System.out.println("Your email: " + userEmail.get(name));
                System.out.println("Your address: " + userAddress.get(name));
                System.out.println("Your nationality: " + userNationality.get(name));
                System.out.println("Your phone: " + userPhone.get(name));
            } else {
                System.out.println("Wrong password");
                login();
            }
        }
    }
}
