package AutomatedTellerMachine;

import java.util.Scanner;

/**
 * Class of AutomatedTellerMachine
 * @author Alex
 */
public class AutomatedTellerMachine {
    private String atmId;
    private User user;
    private Account account;
    private static int nextId = 1;

    public AutomatedTellerMachine() {
        this.atmId = String.format("%06d", nextId++);
        this.user = null;
        this.account = null;
    }
    
    public AutomatedTellerMachine(String atmId) {
        this.atmId = atmId;
        this.user = null;
        this.account = null;
    }
    
    public AutomatedTellerMachine(AutomatedTellerMachine atm) {
        this.atmId = atm.atmId;
        this.user = new User(atm.user);
        this.account = new Account(atm.account);
    }
    
    public void pipeline() {
        printWelcome();
        
        readUserId();
        if (user == null)
            System.exit(1);
        if (!inputPassword())
            System.exit(2);
        
        chooseAccount();
        do {
            int oper = chooseOperation();
            switch (oper) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                default:
                    displayBalance();
            }
        } while (doesContinue());
        
        printGoodbye();
    }
    
    public void printWelcome() {
        System.out.println("Welcome to this ATM.");
    }
    
    /**
     * Asks the user to input the user ID, if it exists, then returns the user object,
     * else will shut down.
     * @return The valid user ID.
     */
    public void readUserId() {
        Scanner con = new Scanner(System.in);
        
        System.out.print("Enter your user ID: ");
        String inputId = con.next();
                
        for (int i = 0; i < Bank.getUsers().size(); i++)
            if (inputId.equals(Bank.getUsers().get(i).getUserId())) {
                user = Bank.getUsers().get(i);
                return;
            }

        System.out.println("Invald ID.");
        user = null;
    }
    
    public boolean inputPassword() {
        Scanner con = new Scanner(System.in);
        int tries = 3;
        
        for (int i = 0; i < tries; i++) {
            System.out.print("Enter your password: ");
            String password = con.next();
            if (user.getPassword().equals(password))
                return true;
            System.out.println("Wrong password.");
        }
        
        System.out.println("Try again.");
        return false;
    }
    
    public void chooseAccount() {
        Scanner con = new Scanner(System.in);
        System.out.print("Choose your account: "
                + "\n\t1. chequing account "
                + "\n\t2. savings account\n");
        int accountChoice = con.nextInt();
        
        account = accountChoice == 1 ? user.getChequingAccount() : user.getSavingAccount();
    }
    
    public int chooseOperation() {
        Scanner con = new Scanner(System.in);
        System.out.print("Choose your operation \n\t1. Withdraw \n\t2. Deposit \n\t3. Display Balance\n");
        int operation = con.nextInt();
        
        return operation;
    }
    
    public boolean withdraw() {
        Scanner con = new Scanner(System.in);
        
        System.out.print("Enter the amount: ");
        double amount = con.nextDouble();
        if (account.getBalance() < amount) {
            System.out.println("You don't have enough.");
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdraw Succesful");
        user.getHistory().add(new Record("withdraw", atmId, amount));
        return true;
       
    }
    
    public boolean deposit() {
        Scanner con = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        double amount = con.nextDouble();

        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit succesfull");
        user.getHistory().add(new Record("withdraw", atmId, amount ));
        return true;
    }
    
    public void displayBalance() {
        System.out.printf("Your current balance is $%.2f", account.getBalance());
    }
    
    public boolean doesContinue() {
        Scanner con = new Scanner(System.in);
        System.out.print("Would you like to continue?");
        int answer = con.nextInt();
        
        return answer == 1;
    }
    
    public void printGoodbye() {
        System.out.println("Thank you for using this ATM. Goobbye for now.");
    }
    
    public boolean equals(AutomatedTellerMachine atm) {
        return this.atmId.equals(atm.atmId);
    }

    @Override
    public String toString() {
        return String.format("%-10s: %s", "ATM ID\n", atmId);
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }
}
