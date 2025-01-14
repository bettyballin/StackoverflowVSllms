#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>
#include <assert.h>

typedef void (*sighandler_t)(int); 

#define SHM_SIZE 8  /* size of shared memory: enough for two 32 bit integers */

volatile int cancontinue = 0;

void halt(char *err) { perror(err); exit(1); }
void handler(int signum) { assert(signum == SIGUSR1); cancontinue = 1; }

int main(void)
{
  key_t key;
  int id;
  int *data;
  pid_t otherpid;

  printf("Hi, I am the %s process and my pid is %d\n", 
#ifdef PRODUCER_MODE
  "writer"
#else
  "reader"
#endif
, getpid());
  printf("Please give me the pid of the other process: ");
  scanf("%d", &otherpid);

  // get a pointer to the shared memory
  if ((key = ftok("test_concur.c", 'R')) == -1) halt("ftok");
  if ((id = shmget(key, SHM_SIZE, 0644 | IPC_CREAT)) == -1) halt("shmget");
  if ((data = shmat(id, (void *)0, 0)) == (int *)(-1)) halt("shmat");

  sighandler_t oldhandler = signal(SIGUSR1, handler);

  while (1) {
#ifdef PRODUCER_MODE
    printf("Enter two integers: ");
    scanf("%d %d", data, data + 1);

    printf("Sending signal to consumer process\n");
    kill(otherpid, SIGUSR1);

    printf("Waiting for consumer to allow me to continue\n");
    while (!cancontinue);
    cancontinue = 0;

    if (*data + *(data + 1) == 0) { printf("Sum was 0, exiting...\n"); break; }
#else
    printf("Waiting for producer to signal me to do my work\n");
    while (!cancontinue);
    cancontinue = 0;

    printf("Received signal\n");
    printf("Pretending to do a long calculation\n");
    sleep(1);
    int sum = *data + *(data + 1);
    printf("The sum of the ints in the shared memory is %d\n", sum);

    printf("Signaling producer I'm done\n");
    kill(otherpid, SIGUSR1);

    if (sum == 0) break;
#endif
  }

  signal(SIGUSR1, oldhandler);

  /* detach from the segment: */
  if (shmdt(data) == -1) {
    perror("shmdt");
    exit(1);
  }

  return 0;
}