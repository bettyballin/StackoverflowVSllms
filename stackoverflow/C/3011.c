void addOpcode(uint32_t *result, uint32_t L, uint32_t R) {\n    *result = L + R;\n}\n\nswitch (opcode) {\n    case ADD:\n            addOpcode(&result, L, R);\n            break;\n     ....