class MyClass {\nprivate:\n    int value;\npublic:\n    MyClass(int v) : value(v) {}\n    int getValue() const { return value; }\n};\n\n// Free function that uses MyClass's public interface\nvoid printValue(const MyClass &obj) {\n    std::cout << obj.getValue() << std::endl;\n}