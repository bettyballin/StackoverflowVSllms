// Example of a concurrency-related bug (deadlock)\n#include <pthread.h>\n\nint shared_resource = 0;\npthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;\npthread_mutex_t mutex2 = PTHREAD_MUTEX_INITIALIZER;\n\nvoid* thread1(void* arg) {\n    pthread_mutex_lock(&mutex1);\n    pthread_mutex_lock(&mutex2);\n    shared_resource++;\n    pthread_mutex_unlock(&mutex2);\n    pthread_mutex_unlock(&mutex1);\n    return NULL;\n}\n\nvoid* thread2(void* arg) {\n    pthread_mutex_lock(&mutex2);\n    pthread_mutex_lock(&mutex1);\n    shared_resource--;\n    pthread_mutex_unlock(&mutex1);\n    pthread_mutex_unlock(&mutex2);\n    return NULL;\n}