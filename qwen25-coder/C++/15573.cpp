// A.cpp\n#include "A.hpp"\n\nint A::count = 0; // Definition and initialization of static member\n\nB::B() {\n    count++;\n}