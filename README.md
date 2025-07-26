To develop a Bank Management System that allows a bank user to create accounts, deposit money, withdraw cash, view mini-statements, check balance, and track all transactions. The system should be easy to use, secure, and mimic real-world ATM functionalities.
1. User Authentication:
Login screen for users with card number and PIN.

Validated against data stored in the MySQL database.

Access denied on wrong credentials.

2. Account Creation Module:
Allows users to sign up for a new bank account.

Collects personal details like Name, DOB, Address, Card Number, and auto-generates a PIN.

Stores account data in the users and login tables.

3. Transaction Module:
After login, users can:

Deposit Money

Withdraw Money

Check Balance

Fast Cash (Withdraw fixed amounts quickly)

View Mini Statement

Change PIN

4. Deposit Module:
User enters amount → Updates balance in bank table with transaction type = "Deposit".

Timestamp is recorded.

5. Withdraw Module:
User enters amount → Checks available balance → Updates balance in bank table with transaction type = "Withdraw".

Handles insufficient balance error.

6. Fast Cash:
Offers predefined withdrawal amounts (e.g., 500, 1000, 2000).

Quick, one-click withdrawal.

7. Balance Enquiry:
Calculates net balance by summing deposits and subtracting withdrawals from bank table.

8. Mini Statement:
Displays last few transactions performed by the user.

Includes date, transaction type, and amount.

9. PIN Change Module:
Updates the existing PIN after verifying the old PIN.
