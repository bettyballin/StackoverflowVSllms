#include <stdio.h>

int main(void) {
    int i = 0;

    if (i += 1 && printf("%d\n", i)) {
        printf("Done: %d.\n", i);
    }

    return 0;
}