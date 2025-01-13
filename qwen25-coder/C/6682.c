#include <stdio.h>\n\n// Default struct layout with natural alignment\nstruct default_struct {\n    char a;\n    int b;\n    short c;\n};\n\n// Packed struct without padding\n#pragma pack(push, 1)\nstruct packed_struct {\n    char a;\n    int b;\n    short c;\n};\n#pragma pack(pop)\n\nint main() {\n    printf("Size of default struct: %lu\n", sizeof(struct default_struct));\n    printf("Size of packed struct: %lu\n", sizeof(struct packed_struct));\n    return 0;\n}