#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdlib.h>

void create_tree(int depth) {
  if (depth == 0 || depth > 7) return; // recursion limit at process PID=5

  pid_t child_pid = fork();

  switch (child_pid) {
    case -1: // Error occurred, exit.
      perror("fork failed");
      exit(1);
      break;
    case  0: // Child Process
        printf ("PID %d created as the PID %d's child\n", getpid(), (int) getppid());
        if ((getpid()-1) % 2 == 0) create_tree(depth + 1);
      break;
    default: // Parent Process
        printf ("PID %d is the parent of PID %d\n", getpid(), child_pid);
        break;
   }
}

int main () {
     int depth = 0;
     create_tree(depth++);
    return 0;
}