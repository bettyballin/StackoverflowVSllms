int calculate_t() {\n    int i;\n    int t = 1;\n    for (i = 2; i < 5; i++) {\n        t *= i;\n    }\n    return t;\n}\n\nint a = calculate_t();