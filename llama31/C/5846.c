// Assuming a 32-bit hardware timer\nuint32_t start_time = read_hardware_timer();\n// Boot sequence code here\nuint32_t end_time = read_hardware_timer();\nprintf("Boot sequence took %u microseconds\n", end_time - start_time);