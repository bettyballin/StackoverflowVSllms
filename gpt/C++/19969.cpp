#include <iostream>\n#include <functional>\n\nclass Base {\npublic:\n    virtual void f1() { std::cout << "Base f1\n"; }\n    virtual void f2() { std::cout << "Base f2\n"; }\n    // Add other functions as needed\n    virtual ~Base() = default;\n};\n\nclass Wrapper : public Base {\npublic:\n    Wrapper(Base* base) : base_(base) {}\n\n    void f1() override {\n        base_->f1();\n        postFunction();\n    }\n\n    void f2() override {\n        base_->f2();\n        postFunction();\n    }\n\n    // Override other functions and add postFunction call\n\nprivate:\n    void postFunction() {\n        std::cout << "Post function call\n";\n    }\n\n    Base* base_;\n};\n\nint main() {\n    Base* base = new Base();\n    Wrapper wrapped(base);\n\n    wrapped.f1(); // Calls Base f1 and then postFunction\n    wrapped.f2(); // Calls Base f2 and then postFunction\n\n    delete base;\n    return 0;\n}