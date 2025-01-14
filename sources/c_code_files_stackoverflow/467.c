pp
#include <iostream>
#include <exception>

int main() {
    try {
        // code that might throw an exception
    }
    catch (const std::exception &ex) {
        // log exception
        std::cerr << "Caught std::exception: " << ex.what() << std::endl;
    }
    catch (...) {
        // log exception
        std::cerr << "Caught unknown exception" << std::endl;
    }
    return 0;
}