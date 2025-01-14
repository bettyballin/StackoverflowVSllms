#include <stdio.h>

// Assuming getBet() function is defined elsewhere
int getBet() {
    int bet;
    printf("Enter your bet: ");
    scanf("%d", &bet);
    return bet;
}

int main() {
    int playerBet = getBet();
    scanf("%*c"); // Consume the newline left by scanf in `getBet()`.
    return 0;
}