#include "FreeRTOS.h"
#include "task.h"
#include "semphr.h"

#define configMINIMAL_STACK_SIZE ( ( unsigned short ) 128 ) // Example stack size definition

void vTaskFunction(void *pvParameters)
{
    for (;;)
    {
        // Task code goes here.
    }
}

int main(void)
{
    xTaskCreate(vTaskFunction, "Task 1", configMINIMAL_STACK_SIZE, NULL, tskIDLE_PRIORITY + 1, NULL);

    // Start the scheduler
    vTaskStartScheduler();

    // If all is well, the scheduler will now be running, and the following line
    // will never be reached.
    for (;;);

    return 0;
}