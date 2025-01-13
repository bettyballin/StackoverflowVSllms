#include "FreeRTOS.h"\n#include "task.h"\n#include "semphr.h"\n\nvoid vTaskFunction(void *pvParameters)\n{\n    for (;;)\n    {\n        // Task code goes here.\n    }\n}\n\nint main(void)\n{\n    xTaskCreate(vTaskFunction, "Task 1", configMINIMAL_STACK_SIZE, NULL, tskIDLE_PRIORITY + 1, NULL);\n\n    // Start the scheduler\n    vTaskStartScheduler();\n\n    // If all is well, the scheduler will now be running, and the following line\n    // will never be reached.\n    for (;;);\n\n    return 0;\n}