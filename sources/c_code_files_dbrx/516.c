#include <stdio.h>

// Function declaration (GCC equivalent of __declspec(dllimport))
extern int AddNumbers(int num1, int num2);

// Define the AddNumbers function (normally this would be in a separate DLL file)
int AddNumbers(int num1, int num2) {
    return num1 + num2;
}

int main() {
    int result = AddNumbers(5, 7);
    printf("Result: %d\n", result);
    return 0;
}