#include <stdio.h>

// Define the handler functions
void handle_load_const(void) {
    printf("Handling LOAD_CONST\n");
}

void handle_add(void) {
    printf("Handling ADD\n");
}

// Define the dispatch table
typedef void (*handler)(void);
static handler dispatch_table[] = { handle_load_const, handle_add };

int main() {
    int running = 1;
    int opcode = 0;

    while (running) {
        // Check if the opcode is within the bounds of the dispatch table
        if (opcode >= 0 && opcode < sizeof(dispatch_table) / sizeof(dispatch_table[0])) {
            dispatch_table[opcode]();
        } else {
            printf("Invalid opcode: %d\n", opcode);
            running = 0;
        }

        // Fetch next opcode...
        opcode++;
        if (opcode >= 2) {
            running = 0;
        }
    }

    return 0;
}