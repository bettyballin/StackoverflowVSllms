#include <stdio.h>

// Define the constants FOO and BAR
#define FOO 1
#define BAR 2

// Function prototype for doStuff()
void doStuff();

int main() {
    int value = FOO;  // Assign some value to test the switch statement

    switch (value) {
        case FOO:  // 'break' inside
        {
            int i;
            doStuff();
            break;
        }

        case BAR: // 'break' inside
        {
            int i;
            doStuff();
            break;
        }

        default:
            // default case if needed
            printf("Default case reached\n");
            break;
    }

    return 0;
}

// Function definition for doStuff()
void doStuff() {
    printf("Doing stuff...\n");
}