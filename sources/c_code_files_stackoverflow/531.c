#include <iostream>

// Define an enum for color codes
enum Colour {
    red = 31,
    green = 32,
    blue = 34,
    // Add more colors as needed
};

// Function to set the text color
std::string setcolour(Colour color) {
    return "\033[" + std::to_string(color) + "m";
}

int main() {
    std::cout << "standard text" << setcolour(red) << "red text" << std::endl;
    std::cout << "\033[0m"; // Reset the color
    return 0;
}