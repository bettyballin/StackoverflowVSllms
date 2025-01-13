#include <stdio.h>\n\nvolatile int lock = 0;\n\nvoid acquire_lock() {\n    while (__sync_lock_test_and_set(&lock, 1)) { \n        /* Do nothing - busy waiting */\n    }\n}\n\nvoid release_lock() {\n    __sync_lock_release(&lock);\n}\n\nvoid critical_section_code() {\n    // Your code here that accesses shared data\n}\n\nvoid thread_safe_function() {\n    acquire_lock();\n    critical_section_code();\n    release_lock();\n}