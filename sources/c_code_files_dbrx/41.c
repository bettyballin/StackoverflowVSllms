#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/procfs.h>
#include <stdlib.h> // for exit()

int main() {
  int fd;
  prpsinfo_t psInfo;
  pid_t pids[1024]; /* maximum number of simultaneous processes is 8192 so we store half to be safe. */
  char procdir[256]; // changed to a fixed-size buffer to avoid buffer overflow

  int maxfds, numProcs;

  if ((maxfds = getdtablesize()) <= 0) {
    perror("cannot find limit on files");
    exit(1);
  }

  for (numProcs = 0; numProcs < maxfds; numProcs++) { /* loop across all possible descriptors */
    sprintf(procdir, "/proc/%d/path", numProcs);
    if ((fd = open(procdir, O_RDONLY)) >= 0) {   /* try if fd is a process */
      pids[numProcs] = numProcs;
      printf("[%d]\n", numProcs);    /* print PID*/
    } else {
      break;
    }

    close(fd); /* close fd since we are done with it. */
  }

  return 0;
}