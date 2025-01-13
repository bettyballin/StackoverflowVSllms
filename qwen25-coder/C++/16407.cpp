struct Foo {\n    Foo(std::string s) : foo_value(s) {}\n\n    bool operator<(const Foo& foo1) const {  // Note: Added const\n        return foo_value < foo1.foo_value;\n    }\n\n    std::string foo_value;\n};