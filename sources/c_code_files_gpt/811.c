#include <stdio.h>

// Define a placeholder for sensor_reading_failed() function
int sensor_reading_failed() {
    // For demonstration purposes, this function always returns 1 (true)
    return 1;
}

// Define a placeholder for use_backup_sensor() function
void use_backup_sensor() {
    printf("Using backup sensor...\n");
}

int main() {
    if (sensor_reading_failed()) {
        use_backup_sensor();
    }
    return 0;
}