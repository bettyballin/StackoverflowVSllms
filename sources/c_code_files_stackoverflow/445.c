pp
#include <vector>
#include <iostream>

template <unsigned long N>
struct Fibonacci
{
    enum
    {
        value = Fibonacci<N-1>::value + Fibonacci<N-2>::value
    };
    static void add_values(std::vector<unsigned long>& v)
    {
        Fibonacci<N-1>::add_values(v);
        v.push_back(value);
    }
};

template <>
struct Fibonacci<0>
{
    enum
    {
        value = 0
    };
    static void add_values(std::vector<unsigned long>& v)
    {
        v.push_back(value);
    }

};

template <>
struct Fibonacci<1>
{
    enum
    {
        value = 1
    };
    static void add_values(std::vector<unsigned long>& v)
    {
        Fibonacci<0>::add_values(v);
        v.push_back(value);
    }
};



int main()
{
    std::vector<unsigned long> fibonacci_seq;
    Fibonacci<45>::add_values(fibonacci_seq);
    for (int i = 0; i <= 45; ++i)
        std::cout << "F" << i << " is " << fibonacci_seq[i] << '\n';
    return 0;
}