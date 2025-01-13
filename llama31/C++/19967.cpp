template<typename T>\nclass Foo\n{\n    template<typename T> // inner T shadows outer T\n    void Bar(const T& bar)\n    {\n        T local = bar; // local is of type inner T, not outer T\n    }\n};\n\nint main()\n{\n    Foo<int> foo;\n    foo.Bar(3.14); // inner T is deduced to be double\n    return 0;\n}