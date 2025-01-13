#include <iostream>\n#include <map>\n#include <utility> // For std::pair\n\nint main() {\n    // Define the map with std::pair<int, int> as the key\n    std::map<std::pair<int, int>, int> coordinate_map;\n\n    // Insert some values\n    coordinate_map[{12, 45}] = 1;\n    coordinate_map[{250000, -250000}] = 2;\n    coordinate_map[{-250000, 250000}] = 3;\n\n    // Access the values\n    std::cout << "Value at (12, 45): " << coordinate_map[{12, 45}] << std::endl;\n    std::cout << "Value at (250000, -250000): " << coordinate_map[{250000, -250000}] << std::endl;\n    std::cout << "Value at (-250000, 250000): " << coordinate_map[{-250000, 250000}] << std::endl;\n\n    return 0;\n}