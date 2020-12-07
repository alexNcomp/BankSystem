package AutomatedTellerMachine;

import java.util.ArrayList;

/**
 *
 * @author Alex Nguyen
 */
public class Bank {
    private static ArrayList<AutomatedTellerMachine> atms = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    
    public static void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
