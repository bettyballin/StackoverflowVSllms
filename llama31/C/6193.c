// Lockless, but not non-blocking\nvoid increment(int* counter) {\n    int old_value = *counter;\n    int new_value = old_value + 1;\n    if (CAS(counter, old_value, new_value) == old_value) {\n        return;\n    } else {\n        // retry or abort\n    }\n}\n\n// Non-blocking, but not lockless\nvoid increment(int* counter) {\n    lock(counter_mutex);\n    *counter += 1;\n    unlock(counter_mutex);\n}