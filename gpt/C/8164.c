#include <stdio.h>\n\n// Define a simple instruction set\n#define OP_HALT 0\n#define OP_ICONST 1\n#define OP_IADD 2\n#define OP_PRINT 3\n\n// A simple bytecode interpreter\nvoid interpret(const unsigned char* bytecode) {\n    int pc = 0;  // Program counter\n    int stack[256];  // Simple stack\n    int sp = -1;  // Stack pointer\n\n    while (1) {\n        unsigned char opcode = bytecode[pc++];\n        switch (opcode) {\n            case OP_HALT:\n                return;\n            case OP_ICONST:\n                stack[++sp] = bytecode[pc++];\n                break;\n            case OP_IADD:\n                stack[sp - 1] = stack[sp - 1] + stack[sp];\n                sp--;\n                break;\n            case OP_PRINT:\n                printf("%d\n", stack[sp--]);\n                break;\n            default:\n                fprintf(stderr, "Unknown opcode %d\n", opcode);\n                return;\n        }\n    }\n}\n\nint main() {\n    // Example bytecode: ICONST 2, ICONST 3, IADD, PRINT, HALT\n    unsigned char bytecode[] = {OP_ICONST, 2, OP_ICONST, 3, OP_IADD, OP_PRINT, OP_HALT};\n    interpret(bytecode);\n    return 0;\n}