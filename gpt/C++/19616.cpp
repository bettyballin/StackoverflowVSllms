#include <vector>\n\nvoid foo(int i, std::vector<int>* optional = nullptr) {\n    if (optional == nullptr) {\n        optional = new std::vector<int>();\n        // fill vector with data\n    }\n    // process vector\n\n    if (optional != nullptr) {\n        delete optional; // Make sure to deallocate if allocated within the function\n    }\n}