#include <windows.h>\n#include <pdh.h>\n#include <iostream>\n\n#pragma comment(lib, "pdh.lib")\n\nint main() {\n    PDH_HQUERY query;\n    PDH_HCOUNTER counter;\n    PDH_FMT_COUNTERVALUE counterVal;\n\n    // Initialize the PDH Query\n    PdhOpenQuery(NULL, NULL, &query);\n    \n    // Replace "ProcessName" with the actual name of the process you want to monitor\n    PdhAddCounter(query, "\\Process(ProcessName)\\% Processor Time", NULL, &counter);\n    PdhCollectQueryData(query);\n\n    while (true) {\n        Sleep(1000); // Wait a second between samples\n        PdhCollectQueryData(query);\n        PdhGetFormattedCounterValue(counter, PDH_FMT_DOUBLE, NULL, &counterVal);\n        std::cout << "CPU Usage: " << counterVal.doubleValue << "%" << std::endl;\n    }\n\n    // Clean up\n    PdhCloseQuery(query);\n    return 0;\n}