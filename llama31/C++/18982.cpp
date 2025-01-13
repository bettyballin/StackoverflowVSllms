// Wrapper.cpp (64-bit)\n#include <Windows.h>\n\n// Load the 32-bit DLL as a data file\nHMODULE hModule = LoadLibraryEx("path/to/32bit.dll", NULL, LOAD_LIBRARY_AS_DATAFILE);\n\n// Get a pointer to the DLL's entry point\nvoid* entryPoint = GetProcAddress(hModule, "EntryPoint");\n\n// Call the entry point\n((void (*)(void))entryPoint)();