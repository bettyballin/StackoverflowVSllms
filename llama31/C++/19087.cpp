class MyClass {\nprivate:\n    int data_;\npublic:\n    friend MyClass operator+(const MyClass& lhs, const MyClass& rhs);\n};\n\nMyClass operator+(const MyClass& lhs, const MyClass& rhs) {\n    MyClass result;\n    result.data_ = lhs.data_ + rhs.data_;\n    return result;\n}