#include <windows.h>\n#include <psapi.h>\n#include <stdlib.h>\n#include <crtdbg.h>\n\n// Function to get memory usage of a process\nDWORD GetProcessMemoryUsage()\n{\n    PROCESS_MEMORY_COUNTERS pmc;\n    GetProcessMemoryInfo(GetCurrentProcess(), &pmc, sizeof(pmc));\n    return pmc.WorkingSetSize;\n}\n\n// Function to get memory usage of a function\nvoid GetFunctionMemoryUsage()\n{\n    _CrtMemState state1, state2, state3;\n\n    // Take a snapshot of the memory state before the function call\n    _CrtMemCheckpoint(&state1);\n\n    // Call the function\n    MyFunction();\n\n    // Take a snapshot of the memory state after the function call\n    _CrtMemCheckpoint(&state2);\n\n    // Calculate the memory usage\n    _CrtMemDifference(&state3, &state1, &state2);\n\n    // Print the memory usage\n    _CrtDumpMemoryLeaks();\n    _CrtMemDumpStatistics(&state3);\n}\n\nint main()\n{\n    // Get memory usage of the process\n    DWORD processMemoryUsage = GetProcessMemoryUsage();\n    printf("Process memory usage: %d bytes\n", processMemoryUsage);\n\n    // Get memory usage of a function\n    GetFunctionMemoryUsage();\n\n    return 0;\n}