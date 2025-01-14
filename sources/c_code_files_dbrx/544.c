#include <stdlib.h>

void fooFunction(char** arr)
{
    int i = 0;
    while (arr[i] != NULL){ // Loop until we reach allocated end of column arrays
      // Process each sub-array 'arr[i]';
      ++i;
    }
}

void allocateAndFill2dArray(char*** arr, int numRows, int* colSizes) {
  *arr = (char**)malloc(sizeof(char *)*(numRows + 1)); // Allocate space for NULL terminator
  for (int i = 0 ; i < numRows;++i){ // Allocate each sub-array with different sizes.
    (*arr)[i]=(char*)malloc(colSizes[i]*sizeof(char));// Here assumes colSizes is filled..
  }
  (*arr)[numRows] = NULL; // Add NULL terminator
}

int main() {
  int colSizes[] = {10, 20, 30};
  int numRows = 3;
  char** arr;
  allocateAndFill2dArray(&arr, numRows, colSizes);
  fooFunction(arr);
  // Don't forget to free the memory!
  for (int i = 0; i < numRows; i++) {
    free(arr[i]);
  }
  free(arr);
  return 0;
}