#ifdef MYDLL_EXPORTS\n#define MYDLL_API __declspec(dllexport)\n#else\n#define MYDLL_API __declspec(dllimport)\n#endif\n\nclass MYDLL_API MyClass {\npublic:\n    MyClass();\n    ~MyClass();\n\n    void myMethod();\n};\n\n// Factory functions\nextern "C" {\n    MYDLL_API MyClass* CreateMyClass();\n    MYDLL_API void DestroyMyClass(MyClass* instance);\n}