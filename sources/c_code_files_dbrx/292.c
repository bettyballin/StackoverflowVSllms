#include <FreeRTOS.h>
#include <task.h>
#include <stdio.h>

// Define the missing variables
TaskHandle_t task1Handle;
#define configMINIMAL_STACK_SIZE 128

void Task1(void *p) {
    printf("Task1 is running...\n");
    for (;;) {
        // Your task code here
        vTaskDelay(1000 / portTICK_PERIOD_MS); // Delay for 1 second
    }
}

int main() {
    xTaskCreate(Task1, (const char *)"Task1", configMINIMAL_STACK_SIZE, NULL, tskIDLE_PRIORITY + 2, &task1Handle);
    vTaskStartScheduler();

    // Should not reach here
    printf("Scheduler exited unexpectedly!\n");
    return 1;
}