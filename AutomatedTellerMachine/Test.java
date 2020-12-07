/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AutomatedTellerMachine;

/**
 *
 * @author Alex
 */
public class Test {
    
    public static void main(String[] args) {
        Bank.addUser("Yi", "1234");
        Bank.addUser("Wang", "2345");
        Bank.addUser("Mike", "3456");
        
        System.out.println(Bank.getUsers());
        Bank.getUsers().get(0);
        
        AutomatedTellerMachine a1 = new AutomatedTellerMachine();
        AutomatedTellerMachine a2 = new AutomatedTellerMachine();
        AutomatedTellerMachine a3 = new AutomatedTellerMachine();
        
        a1.pipeline();
        System.out.println(Bank.getUsers().get(0).getHistory());
    }
}
