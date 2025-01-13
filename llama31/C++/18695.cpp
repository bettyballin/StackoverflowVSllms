#include <functional>\n\nclass MyClass {\npublic:\n    void myFunction(int x) { /* ... */ }\n};\n\nint main() {\n    MyClass obj;\n    std::function<void(int)> callback = [&obj](int x) { obj.myFunction(x); };\n    callback(5); // Calls obj.myFunction(5)\n    return 0;\n}