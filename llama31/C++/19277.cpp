template <unsigned N>\nstruct Fibonacci {\n    enum { value = Fibonacci<N-1>::value + Fibonacci<N-2>::value };\n};\n\ntemplate <>\nstruct Fibonacci<1> {\n    enum { value = 1 };\n};\n\ntemplate <>\nstruct Fibonacci<0> {\n    enum { value = 0 };\n};\n\ntemplate <unsigned N>\nstruct FibonacciTable {\n    static unsigned values[N];\n};\n\ntemplate <unsigned N>\nunsigned FibonacciTable<N>::values[N] = {\n    Fibonacci<0>::value,\n    Fibonacci<1>::value,\n    Fibonacci<2>::value,\n    // ...\n    Fibonacci<N-1>::value\n};\n\nunsigned fibonacci(unsigned index) {\n    return FibonacciTable<40>::values[index]; // assuming 40 is the max value\n}