#include <stdio.h>\n\n// Function declarations\nvoid foo1(char* p1);\nchar* foo2(void);\n\nint main()\n{\n    char* p = NULL;\n\n    foo1(p);\n    foo2();\n}\n\n// Function definitions\nvoid foo1(char* p1)\n{\n}\n\nchar* foo2(void)\n{\n    char* p2 = NULL;\n\n    return p2;\n}