#include <time.h>
#include <stdio.h>  // Added to include the printf function
#include <unistd.h> // Added to include the sleep function

int main(){
    clock_t start = clock();

    sleep(1);  //wait for one second

    clock_t end = clock();

    printf("start = %lu\nend = %lu\n", (unsigned long)start, (unsigned long)end);
    return 0; // Added return statement to indicate successful execution
}