// Original struct with potential padding\nstruct Example {\n    char a;   // 1 byte\n    int b;    // 4 bytes\n    char c;   // 1 byte\n    short d;  // 2 bytes\n};\n\n// Optimized struct with reduced padding\nstruct ExampleOptimized {\n    int b;    // 4 bytes\n    short d;  // 2 bytes\n    char a;   // 1 byte\n    char c;   // 1 byte\n};