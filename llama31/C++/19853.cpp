#include <unordered_map>\n#include <typeindex>\n\nint main() {\n    std::unordered_map<std::type_index, void*> dictionary;\n    dictionary[std::type_index(typeid(int))] = new int(10);\n    return 0;\n}