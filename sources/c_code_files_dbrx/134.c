#include <stdio.h>
#include <stdint.h>

// Define AccountType
typedef struct {
    gint accountNumber;
    // Add other necessary details here
} AccountType;

// Dummy implementation for initAccount
AccountType initAccount(gint accountNumber) {
    AccountType account;
    account.accountNumber = accountNumber;
    // Initialize other details as necessary
    return account;
}

// Dummy implementation for createTransaction
void createTransaction(void* account, gint* transactionId) {
    // Cast the void pointer to AccountType*
    AccountType* acc = (AccountType*)account;
    printf("Processing account number: %d\n", acc->accountNumber);
    // Simulate creating a transaction
    *transactionId = acc->accountNumber * 10; // Example operation
}

void createAccountTransaction(gint accountNumber) {
    AccountType account = initAccount(accountNumber);
    gint transactionId = 0;

    createTransaction((void*)&account, &transactionId);
    printf("Transaction ID: %d\n", transactionId);
}

int main() {
    gint accountNumber = 12345;
    createAccountTransaction(accountNumber);
    return 0;
}