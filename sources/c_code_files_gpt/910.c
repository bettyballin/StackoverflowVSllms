// file2.c
#include <stdio.h>

void func() {  // Definition with external linkage
    printf("Hello, World!\n");
}

int main() {
    func();
    return 0;
}