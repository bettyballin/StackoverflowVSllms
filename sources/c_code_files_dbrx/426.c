#include <stdio.h>

// Example actions to illustrate the issue
void action1() {
    printf("Performing action 1\n");
}

void action2() {
    printf("Performing action 2\n");
}

void extraAction() {
    printf("Performing extra action\n");
}

int main() {
    int condition = 1; // Set condition to true for demonstration

    if (condition) // NO BRACES
        action1();
    else           // NO BRACES
        action2();

    // Later on, more logic is needed based on this condition but the developer forgets to add braces.
    // The else now only applies solely to line 3:

    if (condition)
        action1();
        extraAction();   // This will ALWAYS run!
    else
        action2();

    return 0;
}