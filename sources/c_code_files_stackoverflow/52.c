#include <stdio.h>

// Define the Piece class
class Piece {
public:
    // Define the pieceArray as a static member variable
    static int pieceArray[4][4];

    // Declare the returnPiece function as a member function
    int (*returnPiece(void))[4][4];
};

// Initialize the pieceArray
int Piece::pieceArray[4][4] = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 14, 15, 16}
};

// Define the returnPiece function
int (*Piece::returnPiece(void))[4][4]
{
    // return pointer to the array
    return &pieceArray;
}

int main() {
    Piece piece;
    int (*ptr)[4][4] = piece.returnPiece();

    // Print the contents of the array
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            printf("%d ", (*ptr)[i][j]);
        }
        printf("\n");
    }

    return 0;
}