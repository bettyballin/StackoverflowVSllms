#include <sys/mman.h>    // shm_* / mmap / EXIT_FAILURE
#include <fcntl.h>      // O_* // constants
#include <stdio.h>  // printf
#include <unistd.h> // sysconf
#include <sys/wait.h> // waitpid
#include <stdlib.h> // EXIT_SUCCESS

int main() {
  int psize = sysconf(_SC_PAGE_SIZE);
  int shmfd = shm_open("myshmptr", O_CREAT | O_EXCL | O_RDWR, S_IRUSR|S_IWUSR);
  ftruncate(shmfd, psize);
  void *mapped = mmap(0, psize, PROT_READ | PROT_WRITE, MAP_SHARED, shmfd, 0);
  *(int *)mapped = 0; // initialize the counter to zero.

  pid_t pids[4];

  for (int i=0;i<4; ++i) {
    if ((pids[i] = fork()) == -1) { 
      perror("fork");
      exit(EXIT_FAILURE);
    }
    else if (!pids[i]) { // child process
      __sync_fetch_and_add((int *)mapped, 1); // increment atomically.
      if (i == 3) shm_unlink("myshmptr"); // delete the shared memory after the final child is done.
      return EXIT_SUCCESS;   // exit without calling wait() in children to avoid Zombie processes
    }
  }

  for (int i=0;i<4;++i) { // reap zombies.
    pid_t status = 0;
    waitpid(pids[i], &status, WNOHANG);
    printf("Counter value: %d\n", *(int *) mapped); // Print the counter at each child completion.
  }
  return EXIT_SUCCESS;
}