#include <stdio.h>
#include <time.h>
#include <sys/time.h>

struct timeval {
  time_t tv_sec;
  suseconds_t tv_usec;
};

int main() {
  struct timeval tv;
  gettimeofday(&tv, NULL);
  printf("Seconds: %ld\nMicroseconds: %ld\n", tv.tv_sec, tv.tv_usec);
  return 0;
}