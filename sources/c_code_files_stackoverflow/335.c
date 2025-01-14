#include <stdio.h>

void MyFunction(int x) {
    printf("%d\n", x);
}

int main() {
    int myInt = 5;
    MyFunction(++myInt);
    myInt = 5;  // reset myInt for demonstration
    MyFunction(myInt++);
    return 0;
}