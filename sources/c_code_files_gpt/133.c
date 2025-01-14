#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to get a random available card
int get_random_available_card(int used[], int size) {
    int available_cards[52];
    int available_count = 0;

    // Collect all available cards
    for (int i = 0; i < size; ++i) {
        if (!used[i]) {
            available_cards[available_count++] = i;
        }
    }

    // If no cards are available, return -1
    if (available_count == 0) {
        return -1;
    }

    // Seed the random number generator (do this once at the start of your program)
    srand(time(NULL));

    // Pick a random card from the available cards
    int random_index = rand() % available_count;
    return available_cards[random_index];
}

int main() {
    int used[52] = {0}; // Example: all cards are available
    // Mark some cards as used (example)
    used[0] = 1;
    used[10] = 1;
    used[25] = 1;

    int card = get_random_available_card(used, 52);
    if (card != -1) {
        printf("Random available card: %d\n", card);
    } else {
        printf("No available cards.\n");
    }

    return 0;
}