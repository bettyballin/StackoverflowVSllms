#ifdef MYCLASS_EXPORTS\n#define MYCLASS_API __declspec(dllexport)\n#else\n#define MYCLASS_API __declspec(dllimport)\n#endif\n\nclass MYCLASS_API MyClass {\npublic:\n    MyClass();\n    ~MyClass();\n    void method1();\n    void method2(int);\n};