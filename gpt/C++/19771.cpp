#include <iostream>\n#include "RingBell.h"\n\nextern "C" {\n    int __cdecl ringBell(void)\n    {\n        std::cout << "\a";\n        return 0;\n    }\n}