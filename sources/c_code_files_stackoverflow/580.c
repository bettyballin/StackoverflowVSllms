++
#include <boost/filesystem.hpp>
#include <iostream>

int main() {
    if ( !boost::filesystem::exists( "myfile.txt" ) )
    {
      std::cout << "Can't find my file!" << std::endl;
    }
    return 0;
}