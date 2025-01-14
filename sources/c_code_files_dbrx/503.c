#include <stdio.h>

int getBet () {
    int bet;
    printf("Enter a number: ");
    scanf ("%d", &bet); // Removed "
" here.
    return bet;
}

int main() {
    int bet = getBet();
    return 0;
}