// Example in C\ntypedef void (*opcode_func)(void);\nopcode_func opcode_table[256];\n\nvoid execute_opcode(uint8_t opcode) {\n    opcode_table[opcode]();\n}