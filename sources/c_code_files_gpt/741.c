#include <stdio.h>
#include <stdint.h>

// Define structure to hold task information
typedef struct {
    char td_name[20];
    uint32_t td_cpuUsage;
} TASK_DESC;

// Define function prototypes
int taskInfoGet(int, TASK_DESC *);
int taskIdSelf(void);
int sysClkRateGet(void);
void taskDelay(int);

void monitorPerformance() {
    TASK_DESC desc;
    int taskId = taskIdSelf();
    int clkRate = sysClkRateGet();
    
    while (1) {
        taskInfoGet(taskId, &desc);
        printf("Task: %s, CPU Usage: %u\n", desc.td_name, desc.td_cpuUsage);
        taskDelay(clkRate); // Delay for 1 second
    }
}

int main() {
    monitorPerformance();
    return 0;
}