#include <map>
#include <numeric>
#include <string>

struct SMyStruct {
    int MULT;
    int VAL;
};

typedef std::map<std::string, SMyStruct*> string_to_struct_t;

int add_to_totals(int total, const string_to_struct_t::value_type& data) {
    return total + data.second->MULT * data.second->VAL;
}

string_to_struct_t _idToMyStructMap;

int main() {
    // Initialize _idToMyStructMap with some data...
    // ...

    const int total = std::accumulate(
        _idToMyStructMap.begin(),
        _idToMyStructMap.end(),
        0, 
        add_to_totals);

    return 0;
}