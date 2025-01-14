#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int pCount; // assuming this is defined somewhere in the original code
    pid_t *pID; // assuming this is defined somewhere in the original code

    while(pCount > 0) { // count remaining children here
        int wstatus;
        pid_t done = waitpid(-1, &wstatus, WNOHANG); // -1 means any process/child is valid
        if (done > 0) { // wait was successful
            pCount--;
            for(int i=0 ; i<pCount ; i++) { // find pid in array and shift others to close gap
                if (pID[i] == done){
                    while (i < pCount -1 ) {
                        pID[i] = pID[i+1]; // move everything up array
                        i++;
                    }
                    break; // out of for
                }
            }
            // free(done); // This line is incorrect, as you can't free a pid_t
        } else if (done == 0) { // no child process exited yet, don't stop the loop
            continue;
        } else {// wait was unsuccesful due to an error or there are not child processes left
            perror("waitpid failed");
            exit(1);
        }
    }

    return 0;
}