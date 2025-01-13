#include <mutex>\n\nstd::mutex allocation_mutex;\n\nvoid* operator new(std::size_t size) {\n    std::lock_guard<std::mutex> guard(allocation_mutex);\n    return std::malloc(size);\n}\n\nvoid operator delete(void* ptr) noexcept {\n    std::lock_guard<std::mutex> guard(allocation_mutex);\n    std::free(ptr);\n}