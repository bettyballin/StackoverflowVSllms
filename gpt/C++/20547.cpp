#include <pthread.h>\n#include <iostream>\n\nvoid* MyThreadFunction(void* arg) {\n    std::cout << "Thread is running..." << std::endl;\n    return NULL;\n}\n\nint main() {\n    pthread_t thread;\n    pthread_create(&thread, NULL, MyThreadFunction, NULL);\n    pthread_join(thread, NULL);\n    return 0;\n}