#include <stdio.h>\n#include <unistd.h>\n\nvoid refreshDisplay(int altitude, char* direction, int windSpeed, char* windDirection) {\n    // Clear the screen and move the cursor to the top-left corner\n    printf("\033[H\033[J");\n    printf("Altitude: %dft      Direction: %s\n", altitude, direction);\n    printf("Wind:     %dkm, %s\n", windSpeed, windDirection);\n}\n\nint main() {\n    int altitude = 9876;\n    char direction[] = "NE";\n    int windSpeed = 5;\n    char windDirection[] = "NE";\n\n    while (1) {\n        refreshDisplay(altitude, direction, windSpeed, windDirection);\n        sleep(1);  // Update every second\n\n        // For demo purposes, increment altitude and windSpeed\n        altitude++;\n        windSpeed++;\n    }\n\n    return 0;\n}