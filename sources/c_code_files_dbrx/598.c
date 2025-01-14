#include <stdio.h>
#include <stdlib.h>
#include <time.h> // Include the time.h header for the time function

int main(){
    time_t t;
    srand((unsigned)time(&t)); //initialize random seed generator to generate different sequence with each run
    printf("%d\n", rand()); // Added newline character for proper formatting
    return 0; // Added return statement to indicate successful execution
}