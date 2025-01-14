#include <stdio.h>
#include <stdlib.h>

#define WINDOW_SIZE 5

typedef struct {
    int data[WINDOW_SIZE];
    int start;
    int end;
    int size;
} CircularQueue;

void initQueue(CircularQueue *q) {
    q->start = 0;
    q->end = 0;
    q->size = 0;
}

int isFull(CircularQueue *q) {
    return q->size == WINDOW_SIZE;
}

int isEmpty(CircularQueue *q) {
    return q->size == 0;
}

void enqueue(CircularQueue *q, int value) {
    if (isFull(q)) {
        printf("Queue is full\n");
        return;
    }
    q->data[q->end] = value;
    q->end = (q->end + 1) % WINDOW_SIZE;
    q->size++;
}

int dequeue(CircularQueue *q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return -1;
    }
    int value = q->data[q->start];
    q->start = (q->start + 1) % WINDOW_SIZE;
    q->size--;
    return value;
}

int main() {
    CircularQueue q;
    initQueue(&q);

    enqueue(&q, 1);
    enqueue(&q, 2);
    enqueue(&q, 3);
    enqueue(&q, 4);
    enqueue(&q, 5);

    printf("Dequeued: %d\n", dequeue(&q));
    printf("Dequeued: %d\n", dequeue(&q));

    enqueue(&q, 6);
    enqueue(&q, 7);

    while (!isEmpty(&q)) {
        printf("Dequeued: %d\n", dequeue(&q));
    }

    return 0;
}