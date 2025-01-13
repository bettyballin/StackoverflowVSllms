#include <string>\nusing namespace std;\n\nclass A\n{\n    public:\n    void foo(string s){};\n};\n\nclass B : public A\n{\n    public:\n    using A::foo; // Bring base class foo into scope\n    int foo(int i){};\n};\n\nclass C : public B\n{\n    public:\n    void bar()\n    {\n        string s;\n        foo(s); // Now this will work as expected\n    }\n};