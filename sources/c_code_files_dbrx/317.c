#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

void func() {
    printf("Function called!\n");
}

int main(void) {
    func();  // call func inside this process
    return 0;
}