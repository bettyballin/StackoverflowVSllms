pp
#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <map>

// Assuming Line is a struct or class with a constructor that takes two std::strings
struct Line {
    Line(std::string pc, std::string ct) : pc(pc), ct(ct) {}
    std::string pc;
    std::string ct;
};

int main() {
    std::string line;
    std::map<std::string, std::string> props;
    std::ifstream file("foo.txt");
    if (file.is_open()) {
        while(std::getline(file, line)) {
            std::string token;
            std::istringstream tokens(line);
            while(tokens >> token) {
                std::size_t pos = token.find('=');
                if(pos != std::string::npos) {
                    props[token.substr(0, pos)] = token.substr(pos + 1);
                }
            }

            /* work with those keys/values by doing properties["name"] */
            Line l(props["pc"], props["ct"]);

            /* clear the map for the next line */
            props.clear();
        }
        file.close();
    } else {
        std::cout << "Unable to open file";
        return 1;
    }

    return 0;
}