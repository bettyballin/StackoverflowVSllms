void* writer_thread(void* arg) {\n    writer_lock();\n    // Modify X\n    writer_unlock();\n    return NULL;\n}\n\nvoid* reader_thread(void* arg) {\n    reader_lock();\n    // Read X\n    reader_unlock();\n    return NULL;\n}