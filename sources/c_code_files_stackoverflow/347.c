++
#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstdlib>
#include <ctime>

int main() {
    std::vector<std::string> words;
    std::ifstream in("words.txt");
    if (!in.is_open()) {
        std::cerr << "Unable to open file words.txt\n";
        return 1;
    }
    while(in) {
        std::string word;
        in >> word;
        if (!word.empty()) {
            words.push_back(word);
        }
    }
    in.close();

    std::srand(std::time(0));  // seed for random number generation
    std::string r = words[std::rand() % words.size()];
    std::cout << r << std::endl;

    return 0;
}