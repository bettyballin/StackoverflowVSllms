// MyCppDll.h\n   #pragma once\n\n   #ifdef MYCPPDLL_EXPORTS\n   #define MYCPPDLL_API __declspec(dllexport)\n   #else\n   #define MYCPPDLL_API __declspec(dllimport)\n   #endif\n\n   class MyClass {\n   public:\n       MYCPPDLL_API MyClass();\n       MYCPPDLL_API void MyFunction(int value);\n   };