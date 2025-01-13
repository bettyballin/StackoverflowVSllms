#include <mutex>\n\nstd::mutex allocMutex;\n\nvoid* operator new(std::size_t size) {\n    std::lock_guard<std::mutex> lock(allocMutex);\n    return malloc(size); // Using malloc here, but could use ::operator new too\n}\n\nvoid operator delete(void* ptr) noexcept {\n    std::lock_guard<std::mutex> lock(allocMutex);\n    free(ptr); // Similarly, using free here, but could use ::operator delete too\n}