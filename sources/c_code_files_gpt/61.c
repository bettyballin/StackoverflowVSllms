#include <stdio.h>
#include <stdlib.h>

int main() {
    // Define labels for operations
    static void* dispatch_table[] = { &&op_load_const, &&op_add };
    int opcode = 0; // Example opcode
    int next_opcode = 1; // Example next opcode

    // Dispatch to the operation based on opcode
    goto *dispatch_table[opcode];

    // Operation handlers
    op_load_const:
        printf("Handling LOAD_CONST\n");
        // Simulate determining the next opcode
        next_opcode = 1; // For demonstration, we'll always go to op_add next
        goto *dispatch_table[next_opcode];

    op_add:
        printf("Handling ADD\n");
        // For this example, we'll exit after handling ADD
        return EXIT_SUCCESS;

    // This should not be reached in this example
    printf("Unexpected program flow\n");
    return EXIT_FAILURE;
}