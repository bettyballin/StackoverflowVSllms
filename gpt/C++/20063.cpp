#ifdef MYLIB_EXPORTS\n#define MYLIB_API __declspec(dllexport)\n#else\n#define MYLIB_API __declspec(dllimport)\n#endif\n\nclass MYLIB_API K {\npublic:\n    static int a;\n    static int b;\n};