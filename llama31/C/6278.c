#include <stdio.h>\n#include <stdlib.h>\n#include <stdint.h>\n#include <unistd.h>\n#include <fcntl.h>\n\n#define PAGE_SIZE 4096\n\nint main() {\n    pid_t pid = 1234; // replace with the PID of the process you're interested in\n    uint64_t physical_address = 0x12345678; // replace with the physical address you're interested in\n\n    char maps_path[256];\n    sprintf(maps_path, "/proc/%d/maps", pid);\n\n    FILE *maps_file = fopen(maps_path, "r");\n    if (!maps_file) {\n        perror("fopen");\n        return 1;\n    }\n\n    char pagemap_path[256];\n    sprintf(pagemap_path, "/proc/%d/pagemap", pid);\n\n    int pagemap_fd = open(pagemap_path, O_RDONLY);\n    if (pagemap_fd < 0) {\n        perror("open");\n        return 1;\n    }\n\n    // Iterate over the memory map of the process\n    char line[256];\n    while (fgets(line, sizeof(line), maps_file)) {\n        // Parse the line to get the start and end addresses of the mapping\n        uint64_t start, end;\n        sscanf(line, "%llx-%llx", &start, &end);\n\n        // Check if the physical address falls within this mapping\n        if (physical_address >= start && physical_address < end) {\n            // Get the offset of the physical address within the mapping\n            uint64_t offset = physical_address - start;\n\n            // Use the pagemap file to get the physical address of the page\n            uint64_t page_offset = offset / PAGE_SIZE;\n            uint64_t page_address;\n            pread(pagemap_fd, &page_address, sizeof(page_address), page_offset * sizeof(page_address));\n\n            // Check if the page is present in physical memory\n            if (page_address & (1ULL << 63)) {\n                printf("Process %d owns physical address 0x%llx\n", pid, physical_address);\n                return 0;\n            }\n        }\n    }\n\n    printf("No process owns physical address 0x%llx\n", physical_address);\n    return 0;\n}