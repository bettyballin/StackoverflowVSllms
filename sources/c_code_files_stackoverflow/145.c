pp
#include <algorithm>
#include <vector>
#include <tr1/functional>

struct Second {
    int s1;
};

int main() {
    std::vector<Second> secondVec = {{1}, {2}, {3}};
    std::vector<int> firstVec;

    std::transform(secondVec.begin(),
                   secondVec.end(),
                   std::back_inserter(firstVec),
                   std::tr1::bind(&Second::s1, std::tr1::placeholders::_1));

    return 0;
}