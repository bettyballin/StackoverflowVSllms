#include <vector>
#include <string>
#include <fstream>
#include <sstream>

int main() {
    typedef std::vector<std::vector<std::string> > Rows;
    Rows rows;
    std::ifstream input("filename.csv");
    char const row_delim = '\n';
    char const field_delim = '\t';
    for (std::string row; std::getline(input, row, row_delim); ) {
        rows.push_back(Rows::value_type());
        std::istringstream ss(row);
        for (std::string field; std::getline(ss, field, field_delim); ) {
            rows.back().push_back(field);
        }
    }
    return 0;
}