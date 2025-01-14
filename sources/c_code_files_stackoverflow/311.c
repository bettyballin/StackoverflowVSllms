#include <stdio.h>

int main() {
    int numTwoThirds = 5;  // example value
    int numOneThird = 3;   // example value

    for(int j = numTwoThirds; j < numTwoThirds + numOneThird; j++) {
        printf("%d\n", j);  // print the value of j
    }

    return 0;
}