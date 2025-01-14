// file1.c
#include <stdio.h>

static void func(); // Declaration with internal linkage

int main() {
    func();
    return 0;
}

static void func() { // Definition with internal linkage
    printf("Hello, World!\n");
}