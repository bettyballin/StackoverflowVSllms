#include <stdio.h>

void interrupt_handler() {
    printf("Interrupt handled.\n");
}

int main() {
    interrupt_handler();
    return 0;
}