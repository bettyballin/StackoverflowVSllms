class Example {\n    int x;   // 4 bytes\n    long y;  // 8 bytes\n}\n\n// Memory layout\n// Header (12 bytes) | x (4 bytes) | Padding (4 bytes) | y (8 bytes)