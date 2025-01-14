#include <sys/ptrace.h>
   #include <sys/wait.h>
   #include <sys/user.h>
   #include <unistd.h>
   #include <stdio.h>

   int main(int argc, char *argv[]) {
       pid_t target_pid = atoi(argv[1]);
       // Attach to the target process
       ptrace(PTRACE_ATTACH, target_pid, NULL, NULL);
       waitpid(target_pid, NULL, 0);
       // Inject code here
       ptrace(PTRACE_DETACH, target_pid, NULL, NULL);
       return 0;
   }