#include <stdio.h>

void displayArray(int *array, int len) {
  for (int i=0; i < len; ++i) {
    printf("%d ", array[i]);
  }
}

int main() {
  int array[] = {1, 2, 3, 4, 5};
  int len = sizeof(array) / sizeof(array[0]);
  displayArray(array, len);
  return 0;
}