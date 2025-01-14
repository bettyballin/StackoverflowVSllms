#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

const int MAX_CHILDREN = 10;
int child_fds[MAX_CHILDREN][2]; // Array to hold the file descriptors for each pipe. The first index denotes a pipe and the second (0/1) denote read or write ends of the pipe.

int main() {
    for(int i=0; i < MAX_CHILDREN; ++i){
        if(-1 == pipe(child_fds[i])){
            perror("pipe() failed.");
            exit(-1);
        }
    }
    return 0;
}