#include <stdio.h>

int main() {
    int count = 0;

    // Label naming convention: {Action}_{Location}
    // Action: What will happen when we go to this label (e.g., "continue", "retry", etc.)
    // Location: Where in the code is this label used (method/function, loop names, conditions, etc.).

    loop_start:
        printf("Loop iteration: %d\n", count);
        count++;

        if (count < 5) {
            goto loop_start;
        }

    continue_main:
        printf("Continuing main function...\n");

    return 0;
}