#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <time.h> // Added for srand()

#define ROWS 10
#define COLS 1000000
#define TARGET_NUMBER 5

int matrix[ROWS][COLS]; // Assume this is initialized properly

void initialize_matrix() {
    // Initialize the matrix with some values
    // For simplicity, we'll initialize with random values between 0 and 10
    srand(time(NULL)); // Added to seed the random number generator
    for (int i = 0; i < ROWS; i++) {
        for (int j = 0; j < COLS; j++) {
            matrix[i][j] = rand() % 11;
        }
    }
}

int count_occurrences(int* row, int length, int number) {
    int count = 0;
    for (int i = 0; i < length; i++) {
        if (row[i] == number) {
            count++;
        }
    }
    return count;
}

int main() {
    initialize_matrix();
    
    int fds[ROWS][2];
    int grand_total = 0;

    // Create pipes
    for (int i = 0; i < ROWS; i++) {
        if (pipe(fds[i]) == -1) {
            perror("pipe");
            exit(EXIT_FAILURE);
        }
    }

    for (int i = 0; i < ROWS; i++) {
        pid_t pid = fork();
        
        if (pid == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        }

        if (pid == 0) { // Child process
            close(fds[i][0]);
            int count = count_occurrences(matrix[i], COLS, TARGET_NUMBER);
            write(fds[i][1], &count, sizeof(count));
            close(fds[i][1]);
            exit(EXIT_SUCCESS);
        }
    }

    for (int i = 0; i < ROWS; i++) {
        wait(NULL); // Wait for any child process to finish
    }

    for (int i = 0; i < ROWS; i++) {
        close(fds[i][1]);
        int count;
        read(fds[i][0], &count, sizeof(count));
        close(fds[i][0]);
        printf("Line %d: %d occurrences\n", i, count);
        grand_total += count;
    }

    printf("Grand total occurrences: %d\n", grand_total);

    return 0;
}