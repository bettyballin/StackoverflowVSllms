pp
#include <fstream>
#include <iostream>
#include <iterator>
#include <string>

using namespace std;

int main()
{
    // The one-liner
    string fileContents((istreambuf_iterator<char>(ifstream("filename.txt"))), istreambuf_iterator<char>());

    // Check result
    cout << fileContents;
    return 0;
}