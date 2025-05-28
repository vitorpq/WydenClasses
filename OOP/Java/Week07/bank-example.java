import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Class representing a Bank Account
class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public BankAccount(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, 0.0);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew: " + amount + ". New balance: " + balance);
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }

    public void showAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Class representing a Bank
class Bank {
    private String name;
    private List<BankAccount> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added for " + account.getAccountHolder());
    }

    public void removeAccount(String accountNumber) {
        Optional<BankAccount> accountToRemove = accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst();

        if (accountToRemove.isPresent()) {
            accounts.remove(accountToRemove.get());
            System.out.println("Account " + accountNumber + " removed");
        } else {
            System.out.println("Account " + accountNumber + " not found");
        }
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
        } else {
            for (BankAccount account : accounts) {
                account.showAccountDetails();
                System.out.println(); // Add space between accounts
            }
        }
    }
}

// Main class for testing the program
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");

        BankAccount account1 = new BankAccount("123456", "John Doe");
        BankAccount account2 = new BankAccount("789101", "Jane Smith");

        bank.addAccount(account1);
        bank.addAccount(account2);

        bank.listAccounts();

        BankAccount foundAccount = bank.findAccount("123456");
        if (foundAccount != null) {
            foundAccount.deposit(1000);
        }

        bank.removeAccount("789101");
        bank.listAccounts();
    }
}