#include <stdio.h>

int main() {
    if (1 || 0) {
        /* the first expression is evaluated, it is true, we enter the 'if' block */
        printf("Entered the if block\n");
    }

    int i = 1 | 0;  /* i == 1 */
    printf("i = %d\n", i);

    return 0;
}