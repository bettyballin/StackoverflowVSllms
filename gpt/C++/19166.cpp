#include <iostream>\n#include <string>\n\nclass MyClass {\npublic:\n    MyClass(const std::string& name) : name(name) {}\n\n    void printName() const {\n        std::cout << "Object name: " << name << std::endl;\n    }\n\nprivate:\n    std::string name;\n};\n\nint main() {\n    MyClass obj("MyObjectName");\n    obj.printName();\n\n    return 0;\n}