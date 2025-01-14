#include <stdio.h>

// defining the prototype for function pointer type
typedef void (*funcp_t)(int);

// function to be called via pointer
void myFunction(int i) {
    printf("Calling from %d\n", i);
}

// our "processing" function
void processData(funcp_t op, int param) {
    op(param);
}

int main() {
    // pass the address of the function in our "processing" function as argument (along with additional params)
    processData(myFunction, 10);
    return 0;
}