++
#include <iostream>
#include <map>
#include <utility>

int main() {
    std::map<std::pair<int,int>, int> myMap;

    myMap[std::make_pair(10,20)] = 25;
    std::cout << myMap[std::make_pair(10,20)] << std::endl;

    return 0;
}