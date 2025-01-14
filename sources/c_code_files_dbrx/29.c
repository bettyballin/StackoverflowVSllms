#include <stdio.h>

void func() {
    static int i;  //static local variable
    i+=10;        //retains its value between function calls
    printf("i = %d\n", i);  // Added newline character
}

int main () {
   int x=5, y;

   // Calling the same function multiple times. static variables retain their state on subsequent calls to that function:
   func();  /* Prints "i = " and outputs value of 'i' */
   func();  /* Now it should print twice the earlier one incremented by 10 */
   func();  /* Now it would have incremented by another additional 10 in similar fashion */
   return 0;  // Added return statement
}