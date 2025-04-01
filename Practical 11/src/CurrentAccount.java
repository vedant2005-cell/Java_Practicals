/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package practical.pkg11;

/**
 *
 * @author vedant
 */
class CurrentAccount extends BankAccount {
    private double overdraftLimit = 1000; 

    public CurrentAccount(String holderName, String accountNumber, double balance) {
        super(holderName, accountNumber, balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
        } else {
            System.out.println("Withdrawal denied! Overdraft limit exceeded.");
        }
    }
}
