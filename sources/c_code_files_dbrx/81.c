#include <stdio.h>

int main(void) {
  FILE *fp;

  fp = fopen("test.txt", "a"); // Open in append mode

  if (fp == NULL) {
    printf("Could not open file 'test.txt'\n");
    return -1;
  }

  fprintf(fp, "Hello World\n");
  fflush(fp); /* <-- Flush the stream */

  fclose(fp); // ALWAYS close your streams when you are done
            // to prevent resource leaks!

  return 0;
}