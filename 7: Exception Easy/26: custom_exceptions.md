# Custom Exceptions in Java: Implementation and Usage

Custom exceptions allow you to create application-specific exception types. They are useful for:
1. Providing more meaningful error messages
2. Grouping and categorizing exceptions
3. Adding additional properties to exceptions

Let's create a banking system example to demonstrate custom exceptions.

## 1. Basic Custom Exception

```java
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
```

## 2. Custom Exception with Additional Properties

```java
public class AccountNotFoundException extends Exception {
    private String accountNumber;

    public AccountNotFoundException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
```

## 3. Custom Runtime Exception

```java
public class InvalidTransactionException extends RuntimeException {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
```

## 4. Using Custom Exceptions in a Banking System

```java
import java.util.HashMap;
import java.util.Map;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class Bank {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void createAccount(String accountNumber, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            throw new InvalidTransactionException("Account already exists");
        }
        accounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
    }

    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount) 
            throws AccountNotFoundException, InsufficientFundsException {
        BankAccount fromAccount = getAccount(fromAccountNumber);
        BankAccount toAccount = getAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    private BankAccount getAccount(String accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found", accountNumber);
        }
        return account;
    }
}

public class BankingSystemDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            bank.createAccount("123456", 1000);
            bank.createAccount("789012", 500);

            bank.transferFunds("123456", "789012", 200);
            System.out.println("Transfer successful");

            bank.transferFunds("123456", "999999", 100);  // This will throw AccountNotFoundException
        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage() + " (Account: " + e.getAccountNumber() + ")");
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidTransactionException e) {
            System.out.println("Invalid Transaction: " + e.getMessage());
        }

        try {
            bank.createAccount("123456", 1000);  // This will throw InvalidTransactionException
        } catch (InvalidTransactionException e) {
            System.out.println("Invalid Transaction: " + e.getMessage());
        }
    }
}
```

This example demonstrates:

1. **InsufficientFundsException**: A checked exception for when a withdrawal exceeds the account balance.
2. **AccountNotFoundException**: A checked exception with an additional property (accountNumber) for when an account is not found.
3. **InvalidTransactionException**: An unchecked exception for invalid operations like negative deposits or creating duplicate accounts.

Key points:

- Custom exceptions extend either `Exception` (for checked exceptions) or `RuntimeException` (for unchecked exceptions).
- They can have constructors to set custom messages or additional properties.
- Checked exceptions (`InsufficientFundsException`, `AccountNotFoundException`) must be declared in the method signature and handled explicitly.
- Unchecked exceptions (`InvalidTransactionException`) don't need to be declared or caught explicitly but can be if desired.
- Custom exceptions make the code more readable and allow for more specific error handling.

This banking system example shows how custom exceptions can be used to handle different error scenarios in a more meaningful and organized way, improving the overall robustness and maintainability of the application.