#include <unistd.h>

// Other code...
unsigned int sleepDuration = 100000; // 100 milliseconds ( converted to microseconds)
usleep(sleepDuration);
// Code execution continues after 'sleepDuration' usec