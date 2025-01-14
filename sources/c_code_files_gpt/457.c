#include <stdio.h>
#include <unistd.h>

// Add a compiler flag -D_POSIX_C_SOURCE or use the following line
#define _POSIX_C_SOURCE 199309L

void refreshDisplay(int altitude, char* direction, int windSpeed, char* windDirection) {
    // Clear the screen and move the cursor to the top-left corner
    printf("\033[H\033[J");
    printf("Altitude: %dft      Direction: %s\n", altitude, direction);
    printf("Wind:     %dkm, %s\n", windSpeed, windDirection);
}

int main() {
    int altitude = 9876;
    char direction[] = "NE";
    int windSpeed = 5;
    char windDirection[] = "NE";

    while (1) {
        refreshDisplay(altitude, direction, windSpeed, windDirection);
        sleep(1);  // Update every second

        // For demo purposes, increment altitude and windSpeed
        altitude++;
        windSpeed++;
    }

    return 0;
}