#include <stdio.h>
#include <time.h> // For measuring execution time of your function

// Your function here
void myFunction() {
  printf("Executing function...\n");
  // Add the code you want to measure inside this function
}

int main(void) {
  clock_t start, end; // Clock variables for timing
  double cpu_time_used;

  start = clock(); // Start timer at beginning of execution of myFunction()
  myFunction();
  end = clock(); // End the timer after function has finished execution

  cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;

  printf("The time used is: %f seconds\n", cpu_time_used);

  return 0;
}