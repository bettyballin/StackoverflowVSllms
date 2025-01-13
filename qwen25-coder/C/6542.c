#include "stm32f4xx_hal.h"\n\nTIM_HandleTypeDef htimx; // Assume htimx is your timer handle\n\nvoid startTimer() {\n    __HAL_TIM_RESET_COUNTER(&htimx);\n    HAL_TIM_Base_Start(&htimx);\n}\n\nuint32_t stopTimer() {\n    return __HAL_TIM_GET_COUNTER(&htimx);\n}\n\n// Example short function to measure\nvoid exampleFunction() {\n    // Simulate some processing time\n    int sum = 0;\n    for (int i = 0; i < 1000; ++i) {\n        sum += i * i;\n    }\n}\n\nint main(void) {\n    HAL_Init(); // Initialize the HAL Library\n    SystemClock_Config(); // Configure the system clock\n\n    MX_TIMx_Init(); // Assume this function initializes your timer\n\n    startTimer(); // Start timing\n    exampleFunction(); // Function to measure\n    uint32_t count = stopTimer(); // Stop timing\n\n    printf("Time taken: %lu ticks\n", count); // Output in timer ticks\n\n    return 0;\n}