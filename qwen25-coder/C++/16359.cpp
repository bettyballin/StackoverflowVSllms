class Object {\npublic:\n    // Template member function\n    template<class T>\n    void DoX(T value) {\n        // Function implementation\n    }\n};\n\n// Usage example\nint main() {\n    Object obj;\n    obj.DoX(42);        // Works with int\n    obj.DoX("Hello");   // Works with const char*\n    return 0;\n}