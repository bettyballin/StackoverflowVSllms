#include <stdio.h>

void myFunction() {
    printf("%s\n", __FUNCTION__);
}

int main() {
    myFunction();
    return 0;
}