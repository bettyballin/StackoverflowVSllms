// mylibrary.h\n   #ifdef MYLIBRARY_EXPORTS\n   #define MYLIBRARY_API __declspec(dllexport)\n   #else\n   #define MYLIBRARY_API __declspec(dllimport)\n   #endif\n\n   extern "C" {\n       MYLIBRARY_API void hello();\n   }