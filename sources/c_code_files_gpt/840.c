#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// Function to swap two characters
void swap(char *a, char *b) {
    char temp = *a;
    *a = *b;
    *b = temp;
}

// Function to shuffle the string
void fisherYatesShuffle(char *str, size_t n) {
    if (n > 1) {
        for (size_t i = n - 1; i > 0; i--) {
            size_t j = rand() % (i + 1);
            swap(&str[i], &str[j]);
        }
    }
}

int main() {
    char str[] = "Your 80-character string here..."; // Replace with your actual string
    size_t length = sizeof(str) - 1; // Length of the string excluding the null terminator

    // Seed the random number generator
    srand((unsigned int)time(NULL));

    // Shuffle the string
    fisherYatesShuffle(str, length);

    // Print the shuffled string
    printf("Shuffled string: %s\n", str);

    return 0;
}