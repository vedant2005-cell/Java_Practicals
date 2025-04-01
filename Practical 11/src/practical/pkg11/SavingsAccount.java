/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practical.pkg11;

/**
 *
 * @author vedant
 */
class SavingsAccount extends BankAccount {
    private double interestRate = 2.5; // 2.5% Interest Rate

    public SavingsAccount(String holderName, String accountNumber, double balance) {
        super(holderName, accountNumber, balance);
    }

    public void applyInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest Applied: " + interest);
    }
    
    public void withdraw(double amount) {
        if (amount > 500) {
            System.out.println("Withdrawal limit exceeded! Max Rs 500 allowed.");
        } else {
            super.withdraw(amount);
        }
    }
}
