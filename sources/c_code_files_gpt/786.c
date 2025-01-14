#include <stdio.h>

int main() {
    int condition = 1;

    __asm__ __volatile__ goto (
        "   /* assembly code */ \n"
        "   test %0, %0;       \n"  // Test the condition
        "   jz %l[external_label]; \n"
        :
        : "r" (condition)  // Input operands
        : /* no clobbers */
        : external_label   // List of labels
    );

    /* some C code */
    printf("Code before the label\n");

external_label:
    /* C code continues... */
    printf("Jumped to the label\n");

    return 0;
}