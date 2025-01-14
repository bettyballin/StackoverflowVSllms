#include <stdio.h>

int main() {
    int i = 1; // Example value for i

    if (31 * i == (i << 5) - i) {
        printf("The condition is true.\n");
    } else {
        printf("The condition is false.\n");
    }

    return 0;
}