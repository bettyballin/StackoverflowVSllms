#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <sys/vfs.h>

int main(void) {
  struct statfs fs;
  if (statfs("/", &fs)) { // "/" can be replaced by the path to a file system you want get block size for
     perror("statfs"); 
     exit(1);
  } else {
    printf("%ld bytes\n", (long) fs.f_bsize);
  }
  return 0;
}