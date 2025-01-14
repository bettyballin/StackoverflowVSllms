#include <time.h>

time_t secsToDateTime(struct tm d) {
    return mktime(&d);
}