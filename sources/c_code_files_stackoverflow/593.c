#include <sys/wait.h>
#include <sys/time.h>
#include <iostream>
#include <unistd.h>
#include <cstdlib>

int main() {
    int pidCount = 5; // replace with your actual pid count
    pid_t pids[pidCount]; // replace with your actual pids

    for (int i = 0; i < pidCount; ++i) {
        int status;
        while (-1 == waitpid(pids[i], &status, 0));
        if (!WIFEXITED(status) || WEXITSTATUS(status) != 0) {
            std::cerr << "Process " << i << " (pid " << pids[i] << ") failed" << std::endl;
            exit(1);
        }
    }

    struct timeval second;
    struct timezone tzp;
    gettimeofday (&second, &tzp); //stop time

    return 0;
}