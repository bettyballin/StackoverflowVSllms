#include <time.h>\n#include <stdio.h>\n\nvoid monotonic_sleep(int seconds) {\n    struct timespec ts;\n    clock_gettime(CLOCK_MONOTONIC, &ts);\n    \n    // Calculate the time to wake up\n    ts.tv_sec += seconds;\n\n    // nanosleep until the specified absolute time\n    if (clock_nanosleep(CLOCK_MONOTONIC, TIMER_ABSTIME, &ts, NULL) == 0) {\n        printf("Slept for %d seconds\n", seconds);\n    } else {\n        perror("nanosleep failed");\n    }\n}\n\nint main() {\n    monotonic_sleep(30);\n    return 0;\n}