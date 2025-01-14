#include <stdio.h>
#include <string.h>

void func1() { printf("Func 1 called\n"); }
void func2() { printf("Func 2 called\n"); }

int main(int argc, char* argv[]) {
    if (argc != 3) {
        printf("Usage: %s <funcName> <desc>\n", argv[0]);
        return 1;
    }

    void (*funcPtr)(); 
    if (strcmp(argv[1],"func1") == 0) {       
        funcPtr = func1;                      
    } else if (strcmp(argv[1],"func2") == 0) {
        funcPtr = func2;
    } else {
        printf("Invalid function name\n");       
        return 1;
    }
    (*funcPtr)();                               
    return 0;
}