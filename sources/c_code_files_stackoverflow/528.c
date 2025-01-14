#include <stdio.h>
#include <stdlib.h>

int main() {
    int used[52] = {0}; // Initialize an array to keep track of used cards
    int sofar = 0;
    int selected = -1;
    int i;

    // Seed the random number generator
    srand(time(NULL));

    for (i = 0; i < 52; ++i) {
        if (used[i]) continue;
        ++sofar;
        if ((rand() % sofar) == 0) selected = i;
    }

    if (selected == -1) {
        printf("No usable cards!\n");
        return 1;
    }
    else {
        used[selected] = 1;   // we have selected a card
        printf("Selected card: %d\n", selected);
    }

    return 0;
}