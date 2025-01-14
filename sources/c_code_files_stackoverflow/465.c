#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    char Org_arr[] = "Hello World! This is a test.";
    int print_line_break = 1;
    char* Conv_arr = (char*)malloc(sizeof(char) * strlen(Org_arr) + 1);
    char* Conv_arr_original = Conv_arr;  // Keep track of the original pointer

    for(char* c=Org_arr; *c; ++c) {
       if (*c == ' ') {
          *(Conv_arr++) = *c;
          print_line_break = 1;
       } else {
          // only print 1 '
' for a sequence of space
          if (print_line_break) {
             *(Conv_arr++) = '\n';  // Changed to '\n' for newline character
             print_line_break = 0; 
          }
          *(Conv_arr++) = *c;  // Copy non-space characters
       }
    }
    *Conv_arr = '\0';  // Null-terminate the string

    printf("%s", Conv_arr_original);  // Print the converted string

    free(Conv_arr_original);  // Free the allocated memory

    return 0;
}