#include <stdio.h>

void foo1(char* p1); // prototype
char* foo2(void);     // prototype

main() {
   char* p = NULL;

   foo1(p);
   foo2();
}

// Function definitions
void foo1(char* p1) {}

char* foo2(void){
    char* p2 = NULL;

    return p2;
}