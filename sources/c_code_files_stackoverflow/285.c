#include <stdio.h>

/* disable optimization for this function */
void my_function(void) __attribute__((optimize(0)));

void my_function(void) {
    printf("This is my_function, where optimization is disabled.\n");
}

int main() {
    printf("This is the main function.\n");
    my_function();
    return 0;
}