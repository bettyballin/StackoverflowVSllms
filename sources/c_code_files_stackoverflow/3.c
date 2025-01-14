#include <stdio.h>

// Define the struct outside the function
struct S {
    int a;
};

// Define the enum outside the function
enum E {
    A, B, C
};

void f(struct S arg) {}

enum E f2() {
    // You need to return a value for the enum
    return A;
}

int main() {
    // You need a main function to make the code executable
    return 0;
}