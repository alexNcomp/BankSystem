package AutomatedTellerMachine;

import java.util.ArrayList;

/**
 *
 * @author Alex Nguyen
 */
public class User {
    private String userId;
    private String username;
    private String password;
    private Account savingAccount ;
    private Account chequingAccount ;
    private ArrayList<Record> history;
    private static int nextId = 1;

    public User() {
        this.userId = String.format("%06d\n", nextId++);
        this.username = null;
        this.password = null;
        this.savingAccount = null;
        this.chequingAccount = null;
        this.history = null;
    }
    
    public User(String username, String password) {
        this.userId = String.format("%06d\n", nextId++);
        this.username = username;
        this.password = password;
        this.savingAccount = null;
        this.chequingAccount = new Account();
        this.history = new ArrayList<>();
    }
    
    public User(User user) {
        this.userId = user.userId;
        this.username = user.username;
        this.password = user.password;
        this.savingAccount = new Account(savingAccount);
        this.chequingAccount = new Account(chequingAccount);
        this.history = new ArrayList<>(history);
    }

    @Override
    public String toString() {
        String str = "";
        
        str += userId;
        str += String.format("%-20s: %s\n", "username", username);
        str += String.format("%-20s: %s\n", "password", password);
        str += String.format("%-20s: %s\n", "Saving Account", savingAccount);
        str += String.format("%-20s: %s\n", "Chequing Account", chequingAccount);
        str += String.format("%-20s: %s\n\n", "history", history);

        return str;
    }
    
    public boolean equals(User user) {
        return this.userId.equals(user.userId) &&
                this.username.equals(user.username) &&
                this.password.equals(user.password) &&
                this.savingAccount.equals(user.savingAccount) &&
                this.chequingAccount.equals(user.chequingAccount) &&
                this.history.equals(user.history);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(Account savingAccount) {
        this.savingAccount = savingAccount;
    }

    public Account getChequingAccount() {
        return chequingAccount;
    }

    public void setChequingAccount(Account chequingAccount) {
        this.chequingAccount = chequingAccount;
    }

    public ArrayList<Record> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Record> history) {
        this.history = history;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }
}
