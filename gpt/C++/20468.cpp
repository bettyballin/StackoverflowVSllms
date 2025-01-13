class Base {};\n\nclass MyX : public Base {\n  // Implementation of MyX\n};\n\nclass Derived : public Base {\n  // Implementation of Derived\n};\n\ntemplate<class X>\nclass MyClass : Derived {\nprivate:\n   MyClass(const MyClass& ) = delete;  // Explicitly delete the copy constructor\n\npublic:\n   MyClass(const X& value)\n    : x(value)\n   {}\n\nprivate:\n   X x;\n};\n\n// Usage\nint main() {\n    MyX x;\n    MyClass<MyX> myClass(x);  // Now this should work without ambiguity\n    return 0;\n}