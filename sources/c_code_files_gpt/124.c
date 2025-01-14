// my_program.c
#include <stdio.h>

void hot_function() {
    for (int i = 0; i < 1000000; i++) {
        // Some intensive computation
    }
}

int main() {
    hot_function();
    return 0;
}