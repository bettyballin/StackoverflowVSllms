#include <stdio.h>

void func1() { 
    printf("Function 1 called\n"); 
}

void func2() { 
    printf("Function 2 called\n"); 
}

int main() {
    void (*fun_ptr)(); // declare a function pointer
    fun_ptr = &func1; // assign address of func1 to the function pointer
    (*fun_ptr)();     // call the function using the function pointer
    fun_ptr = &func2; // assign address of func2 to the function pointer
    (*fun_ptr)();     // call the function using the function pointer
    return 0;
}