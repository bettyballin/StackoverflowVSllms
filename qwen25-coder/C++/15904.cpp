#include <iostream>\n#include <cstdlib>\n\nint main(int argc, char* argv[]) {\n    if (argc != 3) { // This means the user did not provide the expected amount of arguments\n        std::cerr << "Usage: " << argv[0] << " num1 num2" << std::endl;\n        return 1; // exit code indicating an error\n    }\n\n    int x = std::atoi(argv[1]); // convert first argument to integer\n    int y = std::atoi(argv[2]); // convert second argument to integer\n\n    int sum = x + y;\n\n    std::cout << "The sum is: " << sum << std::endl;\n\n    return 0;\n}