// mydll.h (not necessary, but included for completeness)\n#ifndef MYDLL_H\n#define MYDLL_H\n\nextern "C" {\n    __declspec(dllexport) int __stdcall foo(long bar);\n}\n\n#endif // MYDLL_H