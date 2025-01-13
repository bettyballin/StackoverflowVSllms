// MyComponent.h\nclass MyComponent {\nprivate:\n    int privateVar;\n\npublic:\n    void setPrivateVar(int value);\n    int getPrivateVar() const;\n    \n    // Declare the test case as a friend\n    friend class TestMyComponent;\n};\n\n// MyComponent.cpp\n#include "MyComponent.h"\nvoid MyComponent::setPrivateVar(int value) { privateVar = value; }\nint MyComponent::getPrivateVar() const { return privateVar; }\n\n// TestMyComponent.cpp\n#include <cassert>\n#include "MyComponent.h"\n\nclass TestMyComponent {\npublic:\n    void testSetAndGetPrivateVar() {\n        MyComponent component;\n        component.privateVar = 42; // Direct access via friendship\n        assert(component.getPrivateVar() == 42);\n    }\n};\n\nint main() {\n    TestMyComponent tester;\n    tester.testSetAndGetPrivateVar();\n    return 0;\n}