#include <iostream>\n#include <chrono>\n#include <thread>\n\nvoid someFunction() {\n    std::this_thread::sleep_for(std::chrono::seconds(1)); // Simulate work\n}\n\nint main() {\n    for (int i = 0; i < 5; ++i) {\n        someFunction();\n    }\n    return 0;\n}