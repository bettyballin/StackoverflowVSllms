#include <stdio.h>

int main() {
    // Declares a char array of 30 rows and 10 columns.
    char a[30][10];

    // Declare an array with 3 rows and 3 columns, and provide initial values
    char ticTacToeBoard[3][3] = {{'x', 'x', 'o'},
                                 {'o', 'o', 'x'},
                                 {'x', 'o', ' '}
                                };

    // Example: Printing the ticTacToeBoard to show it's accessible
    printf("Tic Tac Toe Board:\n");
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf("%c ", ticTacToeBoard[i][j]);
        }
        printf("\n");
    }

    // Since 'a' is a large array without specific initial values,
    // we'll just print a message to show the program has access to it.
    printf("\nThe program has access to array 'a'.\n");

    return 0;
}