struct CompareMyClass {\n    bool operator()(const MyClass& obj, float value) const {\n        return obj.someField < value;\n    }\n};