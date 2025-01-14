#include <stdio.h>

// Define a struct to represent a task
typedef struct Task {
    int priority;
    int holds_resource;
    int needs_resource;
} Task;

// Function to implement priority inheritance protocol
void priority_inheritance(Task *low_priority_task, Task *high_priority_task) {
    if (low_priority_task->holds_resource && high_priority_task->needs_resource) {
        low_priority_task->priority = high_priority_task->priority;
    }
}

int main() {
    // Create two tasks
    Task low_priority_task = {1, 1, 0};  // priority, holds_resource, needs_resource
    Task high_priority_task = {2, 0, 1};

    printf("Before priority inheritance:\n");
    printf("Low-priority task priority: %d\n", low_priority_task.priority);
    printf("High-priority task priority: %d\n", high_priority_task.priority);

    // Apply priority inheritance protocol
    priority_inheritance(&low_priority_task, &high_priority_task);

    printf("After priority inheritance:\n");
    printf("Low-priority task priority: %d\n", low_priority_task.priority);
    printf("High-priority task priority: %d\n", high_priority_task.priority);

    return 0;
}