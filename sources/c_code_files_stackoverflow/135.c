#include <stdio.h>

// Assuming these are defined elsewhere in the code
#define USER_COUNT 10
typedef enum { ON_TIME, LATE_ON_PAYMENTS } CustomerType;
typedef struct { /* customer data */ } Customer;

CustomerType GetCustomerType(Customer customer);
void SendReminder(Customer customer);

int main() {
    Customer Customers[USER_COUNT];

    // Initialize customers...

    for (int i = 0; i < USER_COUNT; ++i) {
        if (GetCustomerType(Customers[i]) == LATE_ON_PAYMENTS) {
            SendReminder(Customers[i]);
        }  // if cust is late on their payments
    }  // for ea customer

    return 0;
}

// Example implementation of GetCustomerType and SendReminder
CustomerType GetCustomerType(Customer customer) {
    // Logic to determine customer type...
    return LATE_ON_PAYMENTS;  // Example return value
}

void SendReminder(Customer customer) {
    printf("Sending reminder to customer...\n");
}