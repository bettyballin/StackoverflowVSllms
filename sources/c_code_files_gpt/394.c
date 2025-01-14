#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void initDeck(int deck[]);
void showDeck(int deck[]);
void shuffleDeck(int deck[]);
int getBet();

int main() {
    int deck[52];
    int playerBet;
    char z;
    initDeck(deck);
    shuffleDeck(deck);
    showDeck(deck);
    playerBet = getBet();
    printf("%d\n", playerBet);
    z = 1;
    getchar();

    return 0;
}

void initDeck(int deck[]) {
    for (int i = 0; i < 52; i++) {
        deck[i] = i + 1;
    }
}

void showDeck(int deck[]) {
    for (int k = 0; k < 52; k++) {
        printf("%d\n", deck[k]);
    }
}

void shuffleDeck(int deck[]) {
    int random, temp;
    srand(time(0));
    for (int k = 51; k > 0; k--) {
        random = rand() % (k + 1);
        temp = deck[k];
        deck[k] = deck[random];
        deck[random] = temp;
    }
}

int getBet() {
    int bet;
    printf("Enter your bet: ");
    scanf("%d", &bet);
    return bet;
}