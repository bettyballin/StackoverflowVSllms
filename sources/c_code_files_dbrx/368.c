#include <stdio.h>

int add_int(int a, int b){ // function declaration 1
    return a + b;
}

char* add_char(int a, int b) { // Renamed the function to avoid redefinition
   // ... do something else
   return "Hello, World!";
}

int main() {
    int result = add_int(5, 3);
    printf("Result: %d\n", result);
    printf("%s\n", add_char(0, 0));
    return 0;
}