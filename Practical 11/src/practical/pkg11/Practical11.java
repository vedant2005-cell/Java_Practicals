/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practical.pkg11;

/**
 *
 * @author vedant
 */
public class Practical11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== SAVING ACCOUNT===");
        SavingsAccount savings = new SavingsAccount("Ramprasad", "Acc12345", 2000);
        savings.deposit(700);
        savings.applyInterest();
        savings.withdraw(600);
        savings.withdraw(200);
        savings.displayBalance();

        System.out.println("\n=== CURRENT ACCOUNT===");
        CurrentAccount current = new CurrentAccount("Gopal", "Acc54321", 5000);
        current.deposit(1000);
        current.withdraw(1200);
        current.withdraw(500);
        current.displayBalance();
    }
}