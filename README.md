
# Bank System Project

This is a `Java` project that simulates a simple bank system with basic functions and features. The project consists of four classes: BankAccount, Transaction, BankingSystem, and Main. Also there is a csv folder used to store the csv files for read/writing operation.

> For a better checking with `.md` file, please open this file inside IntelliJ or other acceptable IDE.

## BankAccount Class

The BankAccount class represents a bank account with information and functionality.
It has three private fields:

- name (account name)
- balance (account balance)
- transactions (a list of Transaction objects)

It also has four public methods:
1. getName (returns the account name)
2. getBalance (returns the account balance)
3. getTransactions (returns the list of transactions)
4. addTransaction (adds a new transaction to the account and updates the balance)

## Transaction Class

The Transaction class represents a bank transaction with information and functionality.

It has two private fields:
- amount (transaction amount)
- details (transaction details)

It also has two public methods:
1. getDetails (returns the transaction details)
2. getAmount (returns the transaction amount)

This class is only used by the BankAccount class, so it is private.

## BankingSystem Class

The BankingSystem class represents the main functionality and logic of the bank system.

It has one static field:
- accounts (List object that stores all the BankAccount objects)

This field is static because it needs to be accessed by the static main method.

It also has six static methods:
1. listAllAccountNames (prints all the account names)
2. viewAccount (prints an individual account information and transactions)
3. removeAccount (removes an account from the list)
4. addTransaction (adds a new transaction to an account)
5. createAccount (creates a new account and adds it to the list)
6. editingWithCSVFile (lets the user choose to read or write to a CSV file)
7. readFromCSVFile (read accounts from a CSV file)
8. writeToCSVFile (write the accounts on Bank System into a CSV file)

## Main Class

The Main class is the entry point of the program. It also initializes the bank system by adding four initial accounts. Then, it uses a while loop to display a menu with seven options, and calls the corresponding BankingSystem method based on the user choice.

On the console, you will see a welcome message and a menu, which lets you choose different functions.

```java
**********************************************************************
**************** Welcome to Steven Banking System ********************
**********************************************************************
Banking System Menu:
[1] List all bank accounts’ names
[2] View an individual bank account(with all transactions records)
[3] Remove a bank account
[4] Add a new transaction to a bank account(-: Withdrawal / +: Deposit)
[5] Create a new bank account
[6] Editing with CSV file
[7] Exit the program
**********************************************************************
Please enter your choice: 
```
You can enter a number, from 1 to 7, to select the function you want to perform. You can press the enter key to confirm your input.

### [1] List all bank accounts’ names:
For example, if you want to list all the bank account names, you can enter 1.

```java
Please enter your choice: 1
----------------------------------------------------------------------
Account Names:      
Steven Chen
Jenny Lilly
Kim Petty
John Snow
----------------------------------------------------------------------
```

### [2] View an individual bank account(with all transactions records)

```java
Please enter your choice: 2
Enter the name of the account you want to view: Steven Chen
----------------------------------------------------------------------
Account Name:       Account Balance:    
Steven Chen         1000.00             

|Transactions|      
----------------------------------------------------------------------
```

### [3] Remove a bank account

```java
Please enter your choice: 3
Enter the name of the account you want to remove: Kim Petty
Account removed.
```

### [4] Add a new transaction to a bank account(-: Withdrawal / +: Deposit)

```java
Please enter your choice: 4
Enter the name of the account you want to add transaction: Steven Chen
Enter transaction details: living cost
Enter transaction amount: -900
Transaction type: Withdrawal
Transaction added.
```

```java
Please enter your choice: 4
Enter the name of the account you want to add transaction: Steven Chen
Enter transaction details: add-on
Enter transaction amount: 1500
Transaction type: Deposit
Transaction added.
```
And you can check the transactions by enter 2:

```java
----------------------------------------------------------------------
Account Name:       Account Balance:    
Steven Chen         1600.00             

|Transactions|      
[Details: living cost]-900.00             
[Details: add-on]   1500.00             
----------------------------------------------------------------------
```

### [5] Create a new bank account

```java
Please enter your choice: 5
Enter the name of the new account: Evan You
Enter the initial balance: 90000
Account created.
```
### [6] Editing with CSV file

```accounts.csv
Steven Chen,1000.0
Elon Musk,100000.0
ABACWS,12689.0
Cardiff University Tuition,27500.0
```

```java
Please enter your choice: 6
Enter the operation you want to make with CSV file.(1 for read, 2 for write)
1
Accounts loaded successfully from CSV file.
```
> Todo this make sure you have a CSV file named "src/csv/accounts.csv" in your project folder, which contains the account information in the format of "name,balance". if you don't have, create one or using write function(enter 2)

Now you can check the accounts in Bank System by entering 1:

```java
Please enter your choice: 1
----------------------------------------------------------------------
Account Names:      
Steven Chen
Jenny Lilly
John Snow
Evan You
Elon Musk
ABACWS
Cardiff University Tuition
----------------------------------------------------------------------
```

As you can see, originally we have 3 accounts(Steven Chen, Jenny Lilly, John Snow), now adding 5 accounts by reading from `acccounts.csv`(John Snow, Evan You, Elon Musk, ABACWS, Cardiff University Tuition). But `John Snow` already exist in our Bank system, so it won't be add agian, checking by line 111 in file `BankingSystem.java` using method:

```BankingSystem.java
account.getName().equalsIgnoreCase(name)
```

And for writing into CSV file (from Bank System):

```java
Please enter your choice: 6
Enter the operation you want to make with CSV file.(1 for read, 2 for write)
2
Accounts write successfully to CSV file.

```

### [7] Exit the program

If you want to exit the program, you can enter 7, and then press the enter key, and the program will print an exit message and end the program.

```java
Please enter your choice: 7
Exiting successfully. Thank you for using the Banking Application, see you soon.
```

### Invalid choice
If the user enters an invalid choice, the program will prompt the user to try again.

```java
Please enter your choice: 0
Invalid choice. Please try again(error input: 0).
```

### Run the program
Method 1:  
Using IntelliJ to open the project, and run the `Main.java` file, you will see the menu on the console.

Method 2:  
Using terminal with command:
>java -jar Java_Assignment.jar

>Remember to change the directory to the folder where the jar file is located
> (out/artifacts/Java_Assignment_jar/Java_Assignment.jar).
