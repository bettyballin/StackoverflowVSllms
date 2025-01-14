pp
#include <iostream>
#include <ostream>

using namespace std;

template <int N>
struct P {
    enum { val = P<N/2>::val * 2 };
};

template <>
struct P<0> {
    enum { val = 1 };
};

template <class T>
struct PadSize {
    enum { val = P<sizeof (T) - 1>::val - sizeof (T) }; 
};

template <class T, int N>
struct PossiblyPadded {
    T       payload;
    char    pad[N]; 
};

template <class T>
struct PossiblyPadded<T, 0> {
    T       payload;
};

template <class T>
struct Holder : public PossiblyPadded<T, PadSize<T>::val> {
};

int main() {
    typedef char Arr[6];

    Holder<Arr> holder;
    cout << sizeof holder.payload << endl;

    // Next line fails to compile if sizeof (Arr) is a power of 2
    // but holder.payload always exists
    cout << sizeof holder.pad << endl;
    return 0;
}