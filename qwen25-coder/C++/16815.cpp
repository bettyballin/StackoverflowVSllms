class B : public A {\npublic:\n    using A::foo; // Bring foo() from base class A into scope\n    int foo(int i) { return 0; } // returning something for demonstration\n};\n\n// Rest of the code remains the same