// C++ Example\nvoid exampleMethod()\n{\n    // Compiler optimizes based on static analysis\n    int* numbers = new int[100];\n    for (int i = 0; i < 100; i++)\n    {\n        numbers[i] = i;\n    }\n    delete[] numbers;\n}