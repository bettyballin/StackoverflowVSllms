pp
#include <boost/tuple/tuple.hpp>
#include <boost/tuple/tuple_io.hpp>

typedef boost::tuple<double, double, double> XYZ;

XYZ foo() {
    // You need to implement this function to return an XYZ tuple
    return boost::make_tuple(1.0, 2.0, 3.0);
}

int main() {
    double x, y, z;
    boost::tie(x, y, z) = foo();
    return 0;
}