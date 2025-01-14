#include <stdio.h>
#include <stdlib.h>

// Define the Instruction struct
typedef struct Instruction {
    void (*handler)(void);
    struct Instruction* next;
} Instruction;

// Define a function to serve as an example handler
void example_handler(void) {
    printf("Example handler called\n");
}

int main() {
    // Create a few example instructions
    Instruction* program_start = malloc(sizeof(Instruction));
    program_start->handler = example_handler;
    program_start->next = malloc(sizeof(Instruction));
    program_start->next->handler = example_handler;
    program_start->next->next = NULL;

    // Initialize the instruction pointer
    Instruction* ip = program_start;

    // Execute the program
    while (ip) {
        ip->handler();
        ip = ip->next;
    }

    // Clean up allocated memory
    free(program_start->next);
    free(program_start);

    return 0;
}