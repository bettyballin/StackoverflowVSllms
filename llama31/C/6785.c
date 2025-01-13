#include <pthread.h>\n#include <stdint.h>\n\nvolatile uint32_t shared_variable;\npthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;\n\nvoid cpu1_write() {\n    pthread_mutex_lock(&mutex);\n    shared_variable = 0x12345678;\n    pthread_mutex_unlock(&mutex);\n}\n\nvoid cpu2_write() {\n    pthread_mutex_lock(&mutex);\n    shared_variable = 0x87654321;\n    pthread_mutex_unlock(&mutex);\n}