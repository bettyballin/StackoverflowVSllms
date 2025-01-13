#include <cassert>\n\ntemplate<unsigned int A, unsigned int B>\nint foo() {\n    static_assert(A >= B, "A must be greater than or equal to B to avoid negative shift.");\n    int v = 1;\n    const int x = A - B;\n\n    if (x > 0) {\n        v = v << x;\n    }\n    bar(v);\n    return v;\n}