// header.h\n#ifdef _WIN32\n#define MY_API __declspec(dllexport)\n#else\n#define MY_API \n#endif\n\nMY_API void myFunction();\n\n// source.cpp\n#include "header.h"\n\nMY_API void myFunction() {\n    // function implementation\n}