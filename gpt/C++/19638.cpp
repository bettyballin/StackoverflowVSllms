// your_application.cpp\n#include <windows.h>\n#include <iostream>\n\nextern "C" void __cdecl your_dll_function();\n\nint main() {\n    std::cout << "Running Windows app on Linux using Winelib" << std::endl;\n    your_dll_function();\n    return 0;\n}