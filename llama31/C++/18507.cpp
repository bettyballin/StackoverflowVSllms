// mydll.cpp\n#include <Windows.h> // not necessary, but included for completeness\n\nextern "C" {\n    __declspec(dllexport) int __stdcall foo(long bar) {\n        return 0;\n    }\n}