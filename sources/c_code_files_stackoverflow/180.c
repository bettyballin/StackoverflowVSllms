pp
#include <fstream>
#include <iostream>

int main() {
    std::ifstream file("file.txt", std::ios::in | std::ios::binary | std::ios::ate);
    if (file.is_open()) {
        file.seekg(0, std::ios::end);
        std::streamsize size = file.tellg();
        char* contents = new char[size];
        file.seekg(0, std::ios::beg);
        file.read(contents, size);
        file.close();
        // ... do something with it
        delete[] contents;
    }
    return 0;
}