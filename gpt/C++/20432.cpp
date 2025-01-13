// A.cpp\n\n#include "A.h"\n#include <iostream>\n\nint A::count = 0;\n\nA::~A() {\n    count--;\n    if (count == 0) {\n        // This is the last one, do something\n        std::cout << "Last instance of A or derived classes destroyed" << std::endl;\n    }\n}\n\nB::B() {\n    count++;\n}