#include <iostream>\n\nint main() {\n    const int maxi = 10;\n    const int maxj = 10;\n    bool stop = false;\n\n    for (int i = 0; i < maxi && !stop; ++i) {\n        for (int j = 0; j < maxj && !stop; ++j) {\n            if (i == 4 && j == 3) {\n                stop = true;\n            }\n            if (stop) {\n                break;\n            }\n            // Your code here\n            std::cout << "i: " << i << ", j: " << j << std::endl;\n        }\n    }\n\n    return 0;\n}