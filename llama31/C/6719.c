#include <stdio.h>\n#include <unistd.h>\n\nint main()\n{\n    int altitude = 9876;\n    char direction[] = "NE";\n    int windSpeed = 5;\n\n    while (1)\n    {\n        printf("\rAltitude: %dft      Direction: %s\n", altitude, direction);\n        printf("\rWind:     %dkm, %s\n", windSpeed, direction);\n\n        // Move cursor to the beginning of the first line\n        printf("\x1B[2A");\n\n        // Update values\n        altitude++;\n        windSpeed++;\n\n        sleep(1);\n    }\n\n    return 0;\n}