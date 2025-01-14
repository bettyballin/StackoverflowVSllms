#include <stdio.h>

// main app (EXE)
int main() {
    printf("Hello from exe!\n");
    return 0; // added return statement to indicate successful execution
}

// shared lib code (DLL)
void test() {
    printf("Hello from dll!\n");
}