import java.util.Scanner; 
public class ATMSimulator { 
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);

        ATM userATM = new ATM(1234, 1000.00);

        System.out.print("Enter your 4-digit PIN: ");
        int enteredPin = input.nextInt();

        if (userATM.authenticate(enteredPin)) {
            System.out.println("Login successful.\n"); 
            int choice;

            do { 
                System.out.println("\tATM Menu"); 
                System.out.println("1. Check Balance"); 
                System.out.println("2. Deposit"); 
                System.out.println("3. Withdraw"); 
                System.out.println("4. Exit"); 
                System.out.print("Select an option: "); 
                choice = input.nextInt(); 

                switch (choice) { 
                    case 1: 
                        userATM.checkBalance(); 
                        break; 
                    case 2: 
                        System.out.print("Enter deposit amount: ₹"); 
                        double depositAmount = input.nextDouble(); 
                        userATM.deposit(depositAmount); 
                        break; 
                    case 3: 
                        System.out.print("Enter withdrawal amount: ₹"); 
                        double withdrawalAmount = input.nextDouble();                
                        userATM.withdraw(withdrawalAmount); 
                        break; 
                    case 4: 
                        System.out.println("Thank you for using the ATM. Goodbye!"); 
                        break; 
                    default: 
                        System.out.println("Invalid option. Please try again."); 
                } 
                System.out.println(); 
            } while (choice != 4); 
        }  
        else { 
                    System.out.println("Incorrect PIN. Access denied."); 
            } 
        input.close(); 
    } 
} 
 
 
class ATM { 
    private final int storedPin; 
    private double balance; 
    private boolean authenticated; 
 
    public ATM(int pin, double initialBalance) { 
        this.storedPin = pin; 
        this.balance = initialBalance; 
        this.authenticated = false; 
    } 
 
    public boolean authenticate(int inputPin) { 
        if (inputPin == storedPin) { 
            authenticated = true; 
        } 
        return authenticated; 
    } 
 
    public void checkBalance() { 
        System.out.printf("Current Balance: ₹%.2f%n", balance); 
    } 
 
    public void deposit(double amount) { 
        if (amount > 0) { 
            balance += amount; 
            System.out.printf("₹%.2f deposited successfully.%n", amount); 
            checkBalance(); 
        }
        else { 
            System.out.println("Invalid deposit amount."); 
        } 
    } 
    public void withdraw(double amount) { 
        if (amount > 0 && amount <= balance) { 
            balance -= amount; 
            System.out.printf("₹%.2f withdrawn successfully.%n", amount); 
            checkBalance(); 
        }  
        else { 
            System.out.println("Insufficient balance or invalid amount."); 
        } 
    } 
    public boolean isAuthenticated() { 
        return authenticated;
    } 
}