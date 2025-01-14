#include <stdio.h>

int sign(int i) {
    if(i > 0) return 1;
    if(i == 0) return 0;    
    return -1; // i<0
}

int main() {
    printf("Sign of 5: %d\n", sign(5));
    printf("Sign of 0: %d\n", sign(0));
    printf("Sign of -3: %d\n", sign(-3));
    return 0;
}