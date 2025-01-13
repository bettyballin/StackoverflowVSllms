#include <iostream>\nusing namespace std;\n\nint main() {\n    double b = 20.0;\n    double c = 5.0;\n\n    // Direct division\n    auto start_time = clock();\n    for (int i = 0; i < 10000000; ++i) {\n        double a = b / c;\n    }\n    auto end_time = clock();\n    cout << "Direct Division took: " << (end_time - start_time) / static_cast<double>(CLOCKS_PER_SEC) << " seconds." << endl;\n\n    // Multiplication with reciprocal\n    start_time = clock();\n    double d = 1.0 / c;\n    for (int i = 0; i < 10000000; ++i) {\n        double a = b * d;\n    }\n    end_time = clock();\n    cout << "Multiplication with reciprocal took: " << (end_time - start_time) / static_cast<double>(CLOCKS_PER_SEC) << " seconds." << endl;\n\n    return 0;\n}