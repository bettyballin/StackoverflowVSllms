#include <iostream>\n#include "IsolatedFunction.h" // Include the header file from the DLL\n\nint main() {\n    int result = IsolatedFunction(5); // Call the function from the DLL\n    std::cout << "Result: " << result << std::endl;\n    return 0;\n}