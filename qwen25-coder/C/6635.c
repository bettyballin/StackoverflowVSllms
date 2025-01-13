#include <stdio.h>\n#include <alloca.h>\n\nvoid process_data() {\n    // Let's assume we need a lot of memory for processing\n    size_t large_size = 1024 * 1024; // 1MB\n    int* buffer = (int*)alloca(large_size); \n\n    // Use the buffer...\n\n    // No need to free buffer, it will be automatically freed when process_data returns\n}\n\nint main() {\n    process_data();\n    return 0;\n}