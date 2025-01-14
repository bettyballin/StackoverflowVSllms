#include <stdio.h>

// Simplified definition of FAILED for demonstration
// In Windows API, FAILED is defined in winerror.h and checks HRESULT values
#define FAILED(hr) ((HRESULT)(hr) < 0)

typedef int HRESULT; // For demonstration, assuming HRESULT is an int type

#define RETURN_ON_FAIL(expression) \
do { \
    HRESULT result = (expression); \
    if (FAILED(result)) { \
        printf("Expression failed with result: %d\n", result); \
        return 1; /* Returning non-zero to indicate failure */ \
    } \
} while (0)

int main() {
    // Example usage
    HRESULT TestFunction() {
        // Simulating a failing call
        RETURN_ON_FAIL(-1);
        // If we reach here, the expression did not fail
        printf("Expression succeeded\n");
        return 0; // Success
    }

    return TestFunction();
}