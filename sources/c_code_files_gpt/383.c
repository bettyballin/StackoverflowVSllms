#include <stdio.h>
#include <stdlib.h>

#define MAX_QUEUE_SIZE 10000

typedef struct {
    int x, y;
} Point;

typedef struct {
    Point data[MAX_QUEUE_SIZE];
    int front, rear;
} Queue;

void initQueue(Queue *q) {
    q->front = q->rear = 0;
}

int isEmpty(Queue *q) {
    return q->front == q->rear;
}

int isFull(Queue *q) {
    return (q->rear + 1) % MAX_QUEUE_SIZE == q->front;
}

void enqueue(Queue *q, Point p) {
    if (!isFull(q)) {
        q->data[q->rear] = p;
        q->rear = (q->rear + 1) % MAX_QUEUE_SIZE;
    }
}

Point dequeue(Queue *q) {
    Point p = { -1, -1 };
    if (!isEmpty(q)) {
        p = q->data[q->front];
        q->front = (q->front + 1) % MAX_QUEUE_SIZE;
    }
    return p;
}

void floodFill(int **image, int width, int height, int x, int y, int newColor) {
    int oldColor = image[x][y];
    if (oldColor == newColor) return;

    Queue q;
    initQueue(&q);

    Point start = { x, y };
    enqueue(&q, start);

    while (!isEmpty(&q)) {
        Point p = dequeue(&q);

        int px = p.x;
        int py = p.y;

        if (px < 0 || px >= width || py < 0 || py >= height) continue;
        if (image[px][py] != oldColor) continue;

        image[px][py] = newColor;

        Point neighbors[4] = {
            { px + 1, py },
            { px - 1, py },
            { px, py + 1 },
            { px, py - 1 }
        };

        for (int i = 0; i < 4; i++) {
            enqueue(&q, neighbors[i]);
        }
    }
}

int main() {
    int width = 5, height = 5;
    int **image = (int **)malloc(width * sizeof(int *));
    for (int i = 0; i < width; i++) {
        image[i] = (int *)malloc(height * sizeof(int));
    }

    // Example image
    int example[5][5] = {
        {1, 1, 1, 2, 2},
        {1, 1, 1, 2, 2},
        {1, 1, 1, 2, 2},
        {3, 3, 3, 2, 2},
        {3, 3, 3, 3, 3}
    };

    for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            image[i][j] = example[i][j];
        }
    }

    floodFill(image, width, height, 1, 1, 9);

    for (int i = 0; i < width; i++) {
        for (int j = 0; j < height; j++) {
            printf("%d ", image[i][j]);
        }
        printf("\n");
    }

    for (int i = 0; i < width; i++) {
        free(image[i]);
    }
    free(image);

    return 0;
}