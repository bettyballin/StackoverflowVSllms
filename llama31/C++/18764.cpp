class A\n{\npublic:\n    explicit A(int x) {}\n};\n\nclass B : public A\n{\npublic:\n    using A::A;  // Inherit A's constructors\n};\n\nint main(void)\n{\n    B *b = new B(5);\n    delete b;\n}