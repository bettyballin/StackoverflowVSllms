#include "MyDll.h"\n\n// Import the template instantiation\ntemplate class __declspec(dllimport) B<int>;\n\nint main() {\n    B<int> b;\n    b.doSomething();\n    return 0;\n}