// mydll.h\nextern "C" __declspec(dllexport) int add(int a, int b);\n\n// mydll.cpp\nint add(int a, int b) {\n    return a + b;\n}