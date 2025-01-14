#include <stdio.h>
#include <string.h>

// Define a function pointer type for the interrupt handler
typedef void (*interrupt_handler)();

// Simulate the oldint65 and newint65 interrupt handlers
void newint65();

// Simulate the geninterrupt function
void geninterrupt(int int_num);

int main()
{
    // Simulate setting the interrupt vector
    printf("Simulating setting interrupt vector...\n");

    // Call the newint65 "interrupt" three times
    newint65();
    newint65();
    newint65();

    return 0;
}

void newint65()
{
    char st[80] = {"Hello World$"};

    // Simulate the interrupt 0x21 call
    printf("%s\n", st);
}

void geninterrupt(int int_num)
{
    // Do nothing, just simulate the geninterrupt function
}