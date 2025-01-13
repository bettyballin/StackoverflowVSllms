#include <type_traits>\n\n// Define an interface using a base class\nstruct IFoo {\n    virtual ~IFoo() = default;\n};\n\n// Generic template class Foo with a constraint\ntemplate <typename T, typename = std::enable_if_t<std::is_base_of<IFoo, T>::value>>\nclass Foo {\npublic:\n    Foo() {\n        // Constructor implementation\n    }\n};\n\nclass Bar : public IFoo {\n    // Implementation of Bar\n};\n\nclass Simpson {\n    // Implementation of Simpson\n};\n\nint main() {\n    Foo<Bar> a; // This will compile\n    // Foo<Simpson> b; // This will cause a compilation error\n    return 0;\n}