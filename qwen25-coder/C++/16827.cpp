#include <iostream>\n\nint main() {\n    // Using an array for a fixed-size buffer\n    char buffer[1024]; // Fixed size, no dynamic memory allocation\n\n    // Example usage: reading from standard input\n    std::cin.read(buffer, sizeof(buffer));\n\n    // Output the content read\n    std::cout.write(buffer, std::cin.gcount());\n\n    return 0;\n}