#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define ROWS 10
#define COLS 10

// Simple maze representation using a 2D array
int board[ROWS][COLS];

void InitializeBoard() {
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            // Initialize all cells as walls (represented by 1)
            board[i][j] = 1;
        }
    }
}

void GenerateRandomMazeEllers() {
    // This is a very simplified version and does not implement Eller's algorithm correctly.
    // It simply randomizes some cells to be paths (represented by 0).
    srand(time(NULL)); // Seed for random number generation
    for (int i = 1; i < ROWS - 1; i++) {
        for (int j = 1; j < COLS - 1; j++) {
            if (rand() % 2 == 0) {
                board[i][j] = 0; // Randomly make some cells paths
            }
        }
    }
}

void PrintBoard() {
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            if (board[i][j] == 1) {
                printf("# "); // Print walls as '#'
            } else {
                printf("  "); // Print paths as spaces
            }
        }
        printf("\n");
    }
}

int main(void) {
    InitializeBoard();
    GenerateRandomMazeEllers(); // Or any other chosen function for generating a randomized maze.
    PrintBoard();
    return 0;
}