#include <time.h>\n\nclock_t start, end;\ndouble cpu_time_used;\n\nstart = clock();\n... /* Do whatever you want to time */\nend = clock();\ncpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;