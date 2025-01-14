pp
#include <map>
#include <iostream>

int main() {
    // Create a map
    std::map<std::string, int> m_ResourceMap;

    // Insert some elements into the map
    m_ResourceMap["Resource1"] = 1;
    m_ResourceMap["Resource2"] = 2;
    m_ResourceMap["Resource3"] = 3;

    // Print the map before erasing an element
    std::cout << "Before erasing:" << std::endl;
    for (const auto& pair : m_ResourceMap) {
        std::cout << pair.first << ": " << pair.second << std::endl;
    }

    // Erase an element from the map
    auto itor = m_ResourceMap.find("Resource2");
    if (itor != m_ResourceMap.end()) {
        m_ResourceMap.erase(itor++);
    }

    // Print the map after erasing an element
    std::cout << "After erasing:" << std::endl;
    for (const auto& pair : m_ResourceMap) {
        std::cout << pair.first << ": " << pair.second << std::endl;
    }

    return 0;
}