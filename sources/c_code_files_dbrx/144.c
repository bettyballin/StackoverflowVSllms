#include <signal.h>  // For stack_t; struct sigaction
#include <sys/resource.h>
#include <stdio.h>

int main() {
    struct rlimit lim; //This structure holds resource limit info
    lim.rlim_cur = 512*1024*1024; /* min stack size */
    lim.rlim_max = 63*1024*1024;// max stack size, or RLIM_INFINITY

    if (setrlimit(RLIMIT_STACK, &lim) == -1) {
        perror("setrlimit");
        return 1;
    }

    return 0;
}