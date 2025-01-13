// MyClass.h\n#ifdef MYCLASS_EXPORTS\n#define MYCLASS_API __declspec(dllexport)\n#else\n#define MYCLASS_API __declspec(dllimport)\n#endif\n\nclass MyClass {\npublic:\n    void doSomething();\n};\n\n// Exported functions to manage the lifecycle of MyClass objects\nextern "C" {\nMYCLASS_API MyClass* createMyClass();\nMYCLASS_API void destroyMyClass(MyClass* obj);\nMYCLASS_API void myClassDoSomething(MyClass* obj);\n}\n\n// MyClass.cpp\n#include "MyClass.h"\n#include <iostream>\n\nvoid MyClass::doSomething() {\n    std::cout << "Doing something!" << std::endl;\n}\n\nextern "C" {\nMYCLASS_API MyClass* createMyClass() {\n    return new MyClass();\n}\n\nMYCLASS_API void destroyMyClass(MyClass* obj) {\n    delete obj;\n}\n\nMYCLASS_API void myClassDoSomething(MyClass* obj) {\n    if (obj) obj->doSomething();\n}\n}