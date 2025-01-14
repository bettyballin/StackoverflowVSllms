#include <stdio.h>
#include <time.h>

// Function to convert second into hours, minutes and seconds
void convert(int sec) {
    int hrs = sec / 3600; //to get no of hours
    sec %= 3600; //seconds left after getting hours
    int min = sec / 60; //to get no of minutes
    sec %= 60; //seconds left after getting minutes
    printf("%d hours, %d minutes and %d seconds\n", hrs, min, sec);
}

int main() {
    clock_t start, end;
    double cpu_time_used;
    int sec;
    start = clock();
    printf("Enter the number of seconds: ");
    scanf("%d", &sec);
    convert(sec); //converts time into hours, minutes and seconds.
    end = clock();
    cpu_time_used = (double) (end - start) / CLOCKS_PER_SEC;  //Calculate time taken in execution of program
    printf("It took %f clicks (%f seconds).\n", cpu_time_used, cpu_time_used);
    return 0;
}