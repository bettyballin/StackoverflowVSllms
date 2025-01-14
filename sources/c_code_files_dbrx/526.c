#include <stdio.h>

void doStuff() {
    printf("Doing stuff...\n");
}

int main() {
    enum { FOO, BAZ } test = FOO;

    switch (test) {
        case FOO:   // 'break' inside
        {
            int i;
            doStuff();
            break; // Break statement placed within the braces/block.
        }

        case BAZ: // 'break' outside
        // Incorrect setup, since break is not encompassed within its respective case condition block and could lead to fall-through in further cases.
        {
            int i;
            doStuff();
        }
        break;

        default:
            printf("Default case reached...\n");
            break;
    }

    return 0;
}