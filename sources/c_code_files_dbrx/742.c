#include <stdio.h>  // For fopen, fclose, etc
#include <stdlib.h> // For exit()
#include <string.h> // For snprintf

int main() {
  char filename[256]; // Should be larger enough for your use case and environment
  snprintf(filename, sizeof(filename), "/home/courses1/cs4352/projects/proj0%s", "/test/file.this");

  FILE *fp = fopen(filename,"r");
  if (fp==NULL) {
    perror("fopen failed: "); // Print the error message to stderr, instead of a user-defined one
    exit(1); // Exit with an appropriate status; 0 indicates success, other values are reserved for errors or abnormal termination.
  } else {
      if (fclose(fp) == EOF) { // Check close() result, especially useful when fp is also used elsewhere in the code
        perror("fclose failed: ");
        exit(1);
      }
    // Continue with other operations as required.
  }
  return 0; // Return an exit status
}