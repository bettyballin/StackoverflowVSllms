#include <stdio.h> // For demonstration; include headers as needed

__attribute__((used)) void foo() {
   printf("Function foo() called.\n"); // Example code
}

int main() {
    foo(); // Call foo() from main()
    return 0;
}