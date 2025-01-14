pp
#include <iostream>
#include <map>
#include <string>
#include <utility>

int main() {
    std::multimap<std::string, std::string> myMultimap;
    myMultimap.insert(std::make_pair("key1", "value1"));
    myMultimap.insert(std::make_pair("key2", "value2"));

    std::pair<std::multimap<std::string, std::string>::iterator, std::multimap<std::string, std::string>::iterator> myPair;

    myPair = myMultimap.equal_range("key1");

    for (std::multimap<std::string, std::string>::iterator it = myPair.first; it != myPair.second; ++it) {
        std::cout << it->first << ": " << it->second << std::endl;
    }

    return 0;
}