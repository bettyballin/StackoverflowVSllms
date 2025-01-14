#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *settings_file = fopen("settings.txt", "r");
    if (settings_file == NULL) {
        printf("Error opening settings file\n");
        return 1;
    }

    char line[1024];
    while (fgets(line, sizeof(line), settings_file)) {
        printf("%s", line);
        // You can parse the line here
    }

    fclose(settings_file);
    return 0;
}