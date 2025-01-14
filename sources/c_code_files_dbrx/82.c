#include <stdio.h>

// Define the IteratorState struct
typedef struct {
    int (*next_func)(void*);
    void* state;
} IteratorState;

// Define the get_next function
int get_next(void* state) {
    int* start = (int*)state;
    (*start)++;
    return *start;
}

int main(void) {
    int start = 10; // Start with some initial position if necessary. (For example, to implement offset).
    IteratorState iters = {&get_next, &start}; // Create an iterator which will yield numbers from start+1 onwards.
    int someCondition = 1; // Define a stopping condition
    int maxIterations = 10; // Limit the number of iterations
    while(someCondition && maxIterations > 0) {  
        int nextVal = (*iters.next_func)(iters.state);
        printf("Next value is: %d\n", nextVal);
        maxIterations--;
    }
    return 0;
}