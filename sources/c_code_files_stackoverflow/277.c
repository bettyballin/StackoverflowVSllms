pp
#include <sstream>
#include <string>

int main() {
    int myInt = 42;
    std::string niceToSeeYouString = "it's nice to see you!";

    std::stringstream ss;
    ss << "Hello, world, " << myInt << " " << niceToSeeYouString;
    std::string s = ss.str();

    // Print the resulting string
    std::cout << s << std::endl;

    return 0;
}