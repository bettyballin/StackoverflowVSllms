pp
#include <iostream>
#include <map>

#define ci(container) container ## iter
#define foreach_value(var, container) \
    for (auto ci(container) = container.begin(); \
         ci(container) != container.end(); ) \
        for (auto var = &ci(container)->second; \
             ci(container) != container.end(); \
             (++ci(container) != container.end()) ? \
                 (var = &ci(container)->second) : var)

int main() {
    std::map<std::string, int> myMap = {{"a", 1}, {"b", 2}, {"c", 3}};
    foreach_value(val, myMap) {
        std::cout << *val << std::endl;
    }
    return 0;
}