#include <stdio.h>

size_t FlatIndex(int i, int j, size_t dimJ)  { 
    return (i * dimJ + j); 
}

void fooFunction(char* arrFlattened, size_t numRows, size_t numCols){
    // Here 'arr' acts like a 2d array. For example:
    char x = arrFlattened[FlatIndex(15,16,numCols)]; 
    // equivalent to arr[15][16] for the flatten array
    printf("%c\n", x); // print the character to verify
}

int main() {
    size_t numRows = 20;
    size_t numCols = 20;
    char arrFlattened[numRows * numCols];
    // Initialize the array with some values
    for (size_t i = 0; i < numRows * numCols; i++) {
        arrFlattened[i] = 'a' + (i % 26); // fill with some characters
    }
    fooFunction(arrFlattened, numRows, numCols);
    return 0;
}