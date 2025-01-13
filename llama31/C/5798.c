#include <idc.idc>\n\nstatic main(void)\n{\n    auto func;\n    auto size;\n\n    for (func = FirstFunction(); func != BADADDR; func = NextFunction(func))\n    {\n        size = GetFunctionSize(func);\n        printf("%08x: %s (%d bytes)\n", func, GetFunctionName(func), size);\n    }\n}