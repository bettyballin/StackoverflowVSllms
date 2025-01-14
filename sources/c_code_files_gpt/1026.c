#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int pid, k, som;
    som = 0; 
    k = 2;
    pid = fork();
    
    if(pid == 0) {
        // Child process
        k = 5;
    } else {
        // Parent process
        wait(0);
    }

    for(int i = 1; i <= k; i++) {
        som += i;
    }

    printf("%d", som);
    return 0;
}