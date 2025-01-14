#include <stdio.h>

// Atomic flag using Test-and-Set
int flag = 0;

void set_flag() {
    __sync_lock_test_and_set(&flag, 1);
}

void clear_flag() {
    __sync_lock_release(&flag);
}

int check_flag() {
    return __sync_lock_test_and_set(&flag, 0);
}

int main() {
    // Example usage:
    printf("Initial flag state: %d\n", flag);
    set_flag();
    printf("Flag state after set: %d\n", flag);
    printf("Check flag: %d\n", check_flag());
    clear_flag();
    printf("Flag state after clear: %d\n", flag);
    return 0;
}