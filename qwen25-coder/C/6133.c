#include <Judy.h>\n#include <stdio.h>\n\nint main() {\n    Pvoid_t PJArray = NULL; // Initialize Judy array\n    Word_t Index;\n    int Rc_int;  // For return codes\n\n    // Insert some memory addresses (indices)\n    Index = 0x12345678;\n    JLI(Rc_int, PJArray, Index);\n    Index = 0x9abcdef0;\n    JLI(Rc_int, PJArray, Index);\n\n    // Check membership of an address\n    Word_t Value;\n    JLG(Rc_int, PJArray, Index);  // This should return non-zero (true)\n    if (Rc_int) {\n        printf("Address %lx is in the set.\n", (unsigned long)Index);\n    } else {\n        printf("Address %lx is not in the set.\n", (unsigned long)Index);\n    }\n\n    // Delete an address\n    Index = 0x12345678;\n    JLD(Rc_int, PJArray, Index);  // This will remove the index from the Judy array\n\n    // Check again after deletion\n    JLG(Rc_int, PJArray, Index);\n    if (!Rc_int) {\n        printf("Address %lx has been removed from the set.\n", (unsigned long)Index);\n    }\n\n    Judy1FreeArray(&PJArray);  // Free memory used by Judy array\n\n    return(0);\n}