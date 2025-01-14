#include <pthread.h>
#include <stdio.h>
#include <unistd.h>

#define STACK_SIZE 4096
#define COMM_THREAD_PRIORITY 10
#define CYCLIC_EXEC_THREAD_PRIORITY 5

void* comm_task(void* data) {
    while (1) {
        // Communication handling code
        usleep(10000); // Delay to allow other threads to execute
    }
}

void* cyclic_exec_task(void* data) {
    while (1) {
        // Cyclic executive code
        // Drive other logical tasks
        // Example:
        // task1();
        // task2();
        // ...
        usleep(1000); // Adjust delay as needed
    }
}

int main(void) {
    pthread_t comm_thread;
    pthread_t cyclic_exec_thread;
    pthread_attr_t comm_thread_attr;
    pthread_attr_t cyclic_exec_thread_attr;
    struct sched_param comm_thread_param;
    struct sched_param cyclic_exec_thread_param;

    pthread_attr_init(&comm_thread_attr);
    pthread_attr_init(&cyclic_exec_thread_attr);

    pthread_attr_setstacksize(&comm_thread_attr, STACK_SIZE);
    pthread_attr_setstacksize(&cyclic_exec_thread_attr, STACK_SIZE);

    comm_thread_param.sched_priority = COMM_THREAD_PRIORITY;
    cyclic_exec_thread_param.sched_priority = CYCLIC_EXEC_THREAD_PRIORITY;

    pthread_attr_setschedparam(&comm_thread_attr, &comm_thread_param);
    pthread_attr_setschedparam(&cyclic_exec_thread_attr, &cyclic_exec_thread_param);

    pthread_create(&comm_thread, &comm_thread_attr, comm_task, NULL);
    pthread_create(&cyclic_exec_thread, &cyclic_exec_thread_attr, cyclic_exec_task, NULL);

    pthread_attr_destroy(&comm_thread_attr);
    pthread_attr_destroy(&cyclic_exec_thread_attr);

    pthread_join(comm_thread, NULL);
    pthread_join(cyclic_exec_thread, NULL);

    return 0;
}