#include <windows.h>
#include <stdio.h>  // Include the header for printf

int main() {
  const char* filename = "your_file";
  DWORD attributes;
  // get current attributes
  attributes = GetFileAttributes(filename);
  if (attributes != INVALID_FILE_ATTRIBUTES) {
    // set file attribute to hidden by using bitwise OR with FILE_ATTRIBUTE_HIDDEN constant.
    SetFileAttributes(filename, attributes | FILE_ATTRIBUTE_HIDDEN);
  } else {
    printf("Couldn't find file %s\n", filename);  // Corrected the printf statement
  }
  return 0;  // Added return statement for main function
}