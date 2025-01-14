pp
#define BOOST_SP_USE_PTHREADS
#include <boost/shared_ptr.hpp>
#include <iostream>

int main() {
    boost::shared_ptr<int> ptr(new int(10));
    std::cout << *ptr << std::endl;
    return 0;
}