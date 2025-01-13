#include <iostream>\n#include <chrono>\n#include <vector>\n\nint main() {\n    const size_t arraySize = 1024 * 1024; // 1 MB\n    std::vector<int> data(arraySize, 0); // Allocate a large array\n\n    // Flush the cache: Write to each element and then flush it from the cache\n    for (size_t i = 0; i < arraySize; ++i) {\n        data[i] += 1;\n    }\n\n    asm volatile ("clflush (%0)" : : "r"(&data[0]) : "memory");\n    \n    // Measure access time after flushing the cache\n    auto start = std::chrono::high_resolution_clock::now();\n    for (size_t i = 0; i < arraySize; ++i) {\n        int temp = data[i]; // Access each element\n    }\n    auto end = std::chrono::high_resolution_clock::now();\n\n    std::cout << "Access time after flushing cache: " \n              << std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count() / arraySize << " ns per access\n";\n\n    // Measure access time without clearing the cache\n    start = std::chrono::high_resolution_clock::now();\n    for (size_t i = 0; i < arraySize; ++i) {\n        int temp = data[i]; // Access each element again, should be in cache now\n    }\n    end = std::chrono::high_resolution_clock::now();\n\n    std::cout << "Access time without clearing cache: " \n              << std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count() / arraySize << " ns per access\n";\n\n    return 0;\n}