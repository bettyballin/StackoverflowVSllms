#include <stdio.h>

// Function prototypes
void action1(void);
void action2(void);
void extraAction(void);

int main() {
    int condition = 1;  // Replace with your actual condition

    if (condition) { 
        action1();
    } else {          
        action2();
    }

    // Later on, to add another action under the same condition safely:
    if (condition) { 
        action1();
        extraAction();        
    } else {
        action2();
    }

    return 0;
}

// Function definitions
void action1(void) {
    printf("Action 1 executed\n");
}

void action2(void) {
    printf("Action 2 executed\n");
}

void extraAction(void) {
    printf("Extra action executed\n");
}