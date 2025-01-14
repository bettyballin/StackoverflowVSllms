#include <stdio.h>
#include <stdlib.h>

// Assume cardInfo is a structure containing info about contactless cards
struct CardInfo {
    // Add some dummy members to make the structure non-empty
    int id;
    char name[256];
};

/* Function to read data from a card */
int readCardData(char *cardName, struct CardInfo *data) {
    FILE *fp;
    fp = fopen(cardName, "r");
    if (fp == NULL) {  /* check for errors in file opening */
        printf("File Not found\n");
        return -1;  // or some other error
    } else {
        // Add some dummy parsing code to make the function non-empty
        char buffer[256];
        while (fgets(buffer, sizeof(buffer), fp)) {
            printf("%s", buffer);
        }
        fclose(fp);
        return 0;  // success
    }
}

int main() {
    struct CardInfo cardData;
    char *cardName = "example.txt";
    int result = readCardData(cardName, &cardData);
    if (result != 0) {
        printf("Error reading card data\n");
    }
    return 0;
}