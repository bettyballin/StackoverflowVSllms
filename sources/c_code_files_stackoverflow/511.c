pp
#include <iostream>
#include <string>

void foo (int const& x) {
    std::cout << "x = " << x << std::endl;
}

void bar (std::string const& s) {
    std::cout << "s = " << s << std::endl;
}

template<class T>
void relay (void (*f)(T const&), T const& a) {
    f(a);
}

int main (int argc, char *argv[])
{
    std::string msg("Hello World!");
    relay (foo, 1138);
    relay (bar, msg);
    return 0;
}