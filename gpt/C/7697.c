#include <windows.h>\n\nvoid* allocate_executable_memory(size_t size) {\n    return VirtualAlloc(NULL, size, MEM_COMMIT | MEM_RESERVE, PAGE_EXECUTE_READWRITE);\n}