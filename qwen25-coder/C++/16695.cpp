#include <map>\n#include <mutex>\n\n// Global Map and Lock\nstd::map<int, std::string> globalMap;\nstd::mutex mapMutex;\n\nextern "C" {\n\n__declspec(dllexport) void AddToGlobalMap(int key, const char* value) {\n    std::lock_guard<std::mutex> lock(mapMutex);\n    globalMap[key] = value;\n}\n\n__declspec(dllexport) void PrintGlobalMap() {\n    std::lock_guard<std::mutex> lock(mapMutex);\n    for (const auto& pair : globalMap) {\n        printf("Key: %d, Value: %s\n", pair.first, pair.second.c_str());\n    }\n}\n\n}