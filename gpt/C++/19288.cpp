#include <iostream>\n\ninline int atomic_add_and_fetch(int* ptr, int value) {\n    int old;\n    __asm__ __volatile__(\n        "lock; xaddl %0, %1"\n        : "=r"(old), "=m"(*ptr)\n        : "0"(value), "m"(*ptr)\n        : "memory"\n    );\n    return old + value;\n}\n\nint main() {\n    int i = 3;\n    int j = atomic_add_and_fetch(&i, 1);\n    std::cout << "i: " << i << ", j: " << j << std::endl;\n    return 0;\n}