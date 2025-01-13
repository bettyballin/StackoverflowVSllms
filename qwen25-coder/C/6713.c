#include <stdio.h>\n#include <stdlib.h>\n#include <string.h>\n#include <sys/time.h>\n\nvoid set_system_time(const char *new_time) {\n    struct timeval tv;\n    struct tm tm;\n\n    // Parse the new time string into a struct tm\n    if (strptime(new_time, "%Y-%m-%d %H:%M:%S", &tm) == NULL) {\n        fprintf(stderr, "Failed to parse time.\n");\n        exit(EXIT_FAILURE);\n    }\n\n    // Convert struct tm to time_t and set it in the struct timeval\n    tv.tv_sec = mktime(&tm);\n    if (tv.tv_sec < 0) {\n        fprintf(stderr, "Invalid time value.\n");\n        exit(EXIT_FAILURE);\n    }\n    tv.tv_usec = 0;\n\n    // Set the system time\n    if (settimeofday(&tv, NULL) != 0) {\n        perror("Failed to set system time");\n        exit(EXIT_FAILURE);\n    }\n\n    // Use hwclock command to sync hardware clock with system time\n    if (system("/sbin/hwclock --systohc") != 0) {\n        fprintf(stderr, "Failed to set hardware clock.\n");\n        exit(EXIT_FAILURE);\n    }\n}\n\nint main() {\n    const char *new_time = "2023-10-05 18:06:00"; // Example new time in YYYY-MM-DD HH:MM:SS format\n    set_system_time(new_time);\n    printf("System and hardware clocks updated to %s\n", new_time);\n    return 0;\n}