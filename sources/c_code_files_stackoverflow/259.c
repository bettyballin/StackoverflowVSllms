#include <stdio.h>
#include <time.h>

int main(int argc, char *argv[]) {
  char ft[256];
  struct tm *tmp;
  time_t curtime;

  time(&curtime);
  tmp = localtime(&curtime);

  strftime(ft, 256, "%Y-%m-%d - %H:%M:%S", tmp);
  printf("%s\n", ft);

  return 0;
}