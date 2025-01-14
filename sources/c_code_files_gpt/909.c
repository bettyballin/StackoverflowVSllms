// file1.c
#include <stdio.h>

void func(); // Declaration with external linkage

void func() { // Definition of func()
    printf("Hello, World!\n");
}

int main() {
    func();
    return 0;
}