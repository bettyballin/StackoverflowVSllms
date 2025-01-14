#include <stdio.h>

// Define the enumeration for function signatures
enum {
    VOID_INT,
    VOID_INT_DOUBLE,
    VOID_DOUBLE_INT
} Signature;

// Implement the do_call function to handle different function signatures
void do_call(const void *userfunction, const void *args, Signature sig) {
    switch(sig) {
        case VOID_INT: {
            int x = *(int *) args;
            void (*f)(int) = userfunction;
            f(x);
            break;
        }
        case VOID_INT_DOUBLE: {
            // Assuming args is a struct or an array containing both int and double
            // For simplicity, let's consider it's a struct with an int followed by a double
            typedef struct { int x; double y; } INT_DOUBLE;
            INT_DOUBLE *arg = (INT_DOUBLE *) args;
            void (*f)(int, double) = userfunction;
            f(arg->x, arg->y);
            break;
        }
        case VOID_DOUBLE_INT: {
            // Similar to VOID_INT_DOUBLE, but with double followed by int
            typedef struct { double y; int x; } DOUBLE_INT;
            DOUBLE_INT *arg = (DOUBLE_INT *) args;
            void (*f)(double, int) = userfunction;
            f(arg->y, arg->x);
            break;
        }
        default:
            printf("Unsupported signature\n");
    }
}

// Example function for each signature
void printInt(int x) {
    printf("Received int: %d\n", x);
}

void printIntDouble(int x, double y) {
    printf("Received int: %d, double: %f\n", x, y);
}

void printDoubleInt(double y, int x) {
    printf("Received double: %f, int: %d\n", y, x);
}

int main() {
    // Prepare arguments
    int intArg = 10;
    typedef struct { int x; double y; } INT_DOUBLE;
    INT_DOUBLE intDoubleArg = {20, 30.5};
    typedef struct { double y; int x; } DOUBLE_INT;
    DOUBLE_INT doubleIntArg = {40.5, 50};

    // Test the do_call function
    do_call(printInt, &intArg, VOID_INT);
    do_call(printIntDouble, &intDoubleArg, VOID_INT_DOUBLE);
    do_call(printDoubleInt, &doubleIntArg, VOID_DOUBLE_INT);

    return 0;
}