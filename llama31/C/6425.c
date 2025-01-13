#include <stdbool.h>\n#include <unistd.h>\n\n// Shared variables\nvolatile bool mutex = false;\nvolatile int turn = 0;\n\n// Function to acquire the mutex\nvoid acquire_mutex(int thread_id) {\n    while (mutex || turn != thread_id) {\n        usleep(1); // Sleep for 1 microsecond\n    }\n    mutex = true;\n    turn = thread_id;\n}