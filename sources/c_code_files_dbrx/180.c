#include <stdio.h>

#define MAX_QUEUE_LEN 10 // Define the maximum queue length

typedef struct {
    int data; // Define the type of data in the queue
} my_data;

typedef struct {
    struct my_data data[MAX_QUEUE_LEN];
    volatile int head;
    volatile int tail;
} my_queue_t;

volatile my_queue_t queue;