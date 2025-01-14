#include <stdio.h>

// Define a simple instruction set
#define OP_HALT 0
#define OP_ICONST 1
#define OP_IADD 2
#define OP_PRINT 3

// A simple bytecode interpreter
void interpret(const unsigned char* bytecode) {
    int pc = 0;  // Program counter
    int stack[256];  // Simple stack
    int sp = -1;  // Stack pointer

    while (1) {
        unsigned char opcode = bytecode[pc++];
        switch (opcode) {
            case OP_HALT:
                return;
            case OP_ICONST:
                stack[++sp] = bytecode[pc++];
                break;
            case OP_IADD:
                stack[sp - 1] = stack[sp - 1] + stack[sp];
                sp--;
                break;
            case OP_PRINT:
                printf("%d\n", stack[sp--]);
                break;
            default:
                fprintf(stderr, "Unknown opcode %d\n", opcode);
                return;
        }
    }
}

int main() {
    // Example bytecode: ICONST 2, ICONST 3, IADD, PRINT, HALT
    unsigned char bytecode[] = {OP_ICONST, 2, OP_ICONST, 3, OP_IADD, OP_PRINT, OP_HALT};
    interpret(bytecode);
    return 0;
}