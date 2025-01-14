++
#include <iostream>
#include <sstream>
#include <vector>
#include <string>

std::vector<std::string> getNextLineAndSplitIntoTokens(std::istream& str)
{
    std::vector<std::string>   result;
    std::string                line;
    std::getline(str,line);

    std::stringstream          lineStream(line);
    std::string                cell;

    while(std::getline(lineStream,cell, ','))
    {
        result.push_back(cell);
    }
    // This checks for a trailing comma with no data after it.
    if (!lineStream && cell.empty())
    {
        // If there was a trailing comma then add an empty element.
        result.push_back("");
    }
    return result;
}

int main() {
    std::string input = "hello,world,,foo,bar,";
    std::istringstream iss(input);
    std::vector<std::string> result = getNextLineAndSplitIntoTokens(iss);
    for (const auto& token : result) {
        std::cout << token << std::endl;
    }
    return 0;
}