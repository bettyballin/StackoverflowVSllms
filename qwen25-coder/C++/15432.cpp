class PluginBase {\npublic:\n    void* operator new(size_t size) {\n        return allocateMemory(size);\n    }\n\n    void operator delete(void* ptr) noexcept {\n        freeMemory(ptr);\n    }\n\nprotected:\n    // Define these as protected so they can't be called directly.\n    static void* allocateMemory(size_t size) {\n        return ::operator new(size);\n    }\n\n    static void freeMemory(void* ptr) noexcept {\n        ::operator delete(ptr);\n    }\n};