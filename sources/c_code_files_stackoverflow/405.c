pp
#include <iostream>

struct PersonId {
    int fId;
};

std::istream& operator >> (std::istream& is, PersonId &p)
{
    is >> p.fId;
    return is;
}

int main() {
    PersonId id;
    std::cin >> id;
    std::cout << id.fId << std::endl;
    return 0;
}