#include <stdio.h>\n\n// Function using fastcall convention\nvoid __fastcall myFunction(int arg1, int arg2) {\n    printf("Arguments: %d, %d\n", arg1, arg2);\n}\n\nint main() {\n    myFunction(1, 2);\n    return 0;\n}