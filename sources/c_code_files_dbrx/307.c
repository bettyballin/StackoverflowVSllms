#include <stdio.h>
#include <string.h>

typedef struct{
  int iData[10];   // An array member.
  char strText[32];// A string/char array.
} STRUCT_DATA;

int main() {
  STRUCT_DATA myData; // Declare a variable of type STRUCT_DATA

  // Initialize the first element of iData array to 10
  myData.iData[0] = 10;

  // Copy the string "Hello, World!" into strText
  strcpy(myData.strText, "Hello, World!");

  // Print the values to verify
  printf("iData[0]: %d\n", myData.iData[0]);
  printf("strText: %s\n", myData.strText);

  return 0;
}