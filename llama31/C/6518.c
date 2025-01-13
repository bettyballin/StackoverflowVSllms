#include <time.h>\n\n// ...\n\nstruct timespec start, end;\nclock_gettime(CLOCK_PROCESS_CPUTIME_ID, &start);\n\n// Your long computation here...\n\nclock_gettime(CLOCK_PROCESS_CPUTIME_ID, &end);\n\ndouble cpu_time = (end.tv_sec - start.tv_sec) + (end.tv_nsec - start.tv_nsec) * 1e-9;