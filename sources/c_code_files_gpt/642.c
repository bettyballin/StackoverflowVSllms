#include <stdio.h>

void myFunction() {
    static int counter = 0; // This variable retains its value between function calls
    counter++;
    printf("%d\n", counter);
}

int main() {
    myFunction();
    myFunction();
    myFunction();
    return 0;
}