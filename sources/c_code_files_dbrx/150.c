#include <stdio.h>
#include <unistd.h>

int main() {
    int pid, k = 2; 
    int som = 0;         

    pid = fork();

    if(pid == 0){   
        printf("Child PID: %d, k value set to: 5\n", getpid()); 
        k = 5; 
    } else{          
        printf("Parent PID: %d still using k value as: 2\n", getpid());   
    }

    for(int i = 1; i <= k; i++)
        som += i; 
    printf("Final sum: %d\n", som);    
    return 0;
}