#include <stdio.h>
#include <stdlib.h>

void check_stack_growth(int *initial_address) {
    int current_variable;
    if (initial_address > &current_variable) {
        printf("Stack grows downwards.\n");
    } else {
        printf("Stack grows upwards.\n");
    }
}

int main() {
    int initial_variable;
    check_stack_growth(&initial_variable);
    return EXIT_SUCCESS;
}