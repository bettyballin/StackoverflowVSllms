#include <dmtcp.h>
#include <stdio.h>

// Your application logic goes here.. For simplicity, let us imagine we have some global variables which gets its value during the execution of this function
void myProgramLogic() {
    int A = 0;
    // Code initializing and modifying 'A'
    A = 10;  // Let's say the value of 'A' changes during execution.
    printf("Value of A: %d\n", A);
}

int main() {
    DMTCP_CHECKPOINT("myProg", NULL, myProgramLogic);       // This would save checkpoint with name "myProg" when signalled by DMTCP daemon.
    return 0;
}