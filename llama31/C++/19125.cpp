// mydll.cpp\n#include "mydll.h"\n#include "myexception.h"\n\nvoid MyFunction() {\n    throw MyException("Something went wrong");\n}