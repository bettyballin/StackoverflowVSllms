#include <stdio.h>\n\nextern "C" __declspec(dllexport) void DisplayHelloFromDLL()\n{\n    printf("Hello from the World of 1986!\n");\n}