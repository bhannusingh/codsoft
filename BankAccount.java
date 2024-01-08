import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class representing the ATM machine
public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void executeOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                // Withdraw
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (userAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + userAccount.getBalance());
                } else {
                    System.out.println("Insufficient funds. Withdrawal failed.");
                }
                break;

            case 2:
                // Deposit
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
                break;

            case 3:
                // Check Balance
                System.out.println("Current balance: $" + userAccount.getBalance());
                break;

            case 4:
                // Exit
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();

        // Create a BankAccount instance
        BankAccount userAccount = new BankAccount(initialBalance);

        // Create an ATM instance connected to the user's bank account
        ATM atm = new ATM(userAccount);

        while (true) {
            // Display the ATM menu
            atm.displayMenu();

            // Get user input for the selected option
            System.out.print("Select an option (1-4): ");
            int option;

            // Validate user input
            while (true) {
                try {
                    option = Integer.parseInt(scanner.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid input. Enter a number (1-4): ");
                }
            }

            // Execute the chosen option
            atm.executeOption(option);
        }
    }
}
