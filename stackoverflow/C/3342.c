// File: callcaphooks.c\n\n#include <stdio.h>\nint main();\n\nvoid _CAP_Enter_Function(void *p) \n{\n    if (p != main) \n        printf("Enter function   (at address %p) at %d\n", \n            p, GetTickCount());\n        return;\n}\nvoid _CAP_Exit_Function(void *p) \n{\n    if (p != main) \n        printf("Leaving function (at address %p) at %d\n", \n            p, GetTickCount());\n    return;\n}